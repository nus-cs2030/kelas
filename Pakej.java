import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;

class Pakej {
    /**
     * Check if classes exist
     *
     * @param classes List<String> of class names to check for existence
     * @throws ClassNotFoundException Thrown if the class is not valid.
     */
    public static Boolean checkIfClassesExist(List<String> classes) {
        Boolean allClassesFound = true;
        for (String name : classes) {
            try {
                new Kelas(name);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + name);
                allClassesFound = false;
            }
        }
        return allClassesFound;
    }

    /**
     * Check if public fields exist
     *
     * @param className The name of the class.
     * @throws ClassNotFoundException Thrown if the className is not valid.
     */
    public static void checkPublicFields(List<String> classes) {
        for (String name : classes) {
            try {
                Kelas kelas = new Kelas(name);
                if (kelas.containsPublicFields()) {
                    //System.out.println(name + ": contains public fields:");
                    for (Field f : kelas.getPublicFields()) {
                        //System.out.println(" - " + f);
                    }
                }
            } catch (ClassNotFoundException e) {
            }
        }
    }

    // MUST MEANS NEGATIVE - and print out
    public static void mustHaveNonPublicAndFinalFields(String name) {
        try {
            Kelas kelas = new Kelas(name);
            List<Field> list = kelas.getAllFields()
                    .stream()
                    .filter(f -> (!Modifier.isPrivate(f.getModifiers()) && !Modifier.isProtected(f.getModifiers())) || !Modifier.isFinal(f.getModifiers()))
                    .collect(Collectors.toList());

            if (!list.isEmpty()) {
                //System.out.println(name + ": contains public/default or non final fields:");
                for (Field f : list) {
                    //System.out.println(" - " + f);
                }
            }
        } catch (ClassNotFoundException e) {
        }
    }

    // MUST MEANS NEGATIVE - and print out
    public static void mustHavePrivateAndFinalFields(String name) {
        try {
            Kelas kelas = new Kelas(name);
            List<Field> list = kelas.getAllFields()
                    .stream()
                    //.peek(System.out::println)
                    .filter(f -> !Modifier.isPrivate(f.getModifiers()) || !Modifier.isFinal(f.getModifiers()))
                    .collect(Collectors.toList());

            if (!list.isEmpty()) {
                //System.out.println("The class " + name + " contains non private or non final fields:");
                for (Field f : list) {
                    //System.out.println(" - " + f);
                }
                //System.out.println("As a general rule, don't assign a more permissive access modifier than necessary. Also, remember to use final when writing classes which are immutable.\n");
            }

        } catch (ClassNotFoundException e) {
        }
    }

    public static void mustHaveCommonParent(String name1, String name2)
            throws ClassNotFoundException {
        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);
        if (!k1.shareCommonSupertypeWith(k2)) {
            //System.out.println(name1 + " and " + name2 + " do not have a common parent. Revisit the question and make sure you are not missing any inheritance requirements.\n");
        }
    }

    public static Boolean mustBeChildOf(String child, String parent) throws ClassNotFoundException {
        Kelas k1 = new Kelas(child);
        Boolean isChildOf = k1.isChildOf(parent);
        if (!isChildOf) {
            //System.out.println(child + " does not inherit from " + parent + ". Revisit the question and make sure you are not missing any inheritance requirements.\n");
        }
        return isChildOf;
    }

    public static void mustNotHaveExtraMethods(String className, String... methodNames)
            throws ClassNotFoundException {
        Kelas k1 = new Kelas(className);
        String msg = "The class " + className + " has overloaded methods:";
        boolean extra = false;
        for (String name : methodNames) {
            boolean found = false;
            for (Method m : k1.getMethods()) {
                if (m.getName().equals(name)) {
                    if (found) {
                        msg += "\n - " + m;
                        extra = true;
                    }
                    found = true;
                }
            }
        }
        if (extra) {
            //System.out.println(msg+"\nMake sure you don't use overloading unnecessarily.\n");
        }
    }

    public static void mustNotHaveOnlyInterfaceAsParent(String name1, String name2)
            throws ClassNotFoundException {
        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);
        if (k1.shareCommonSupertypeWith(k2)) {
            // Check if common parent of cab and car consists of only interfaces (should not)
            List<Class<?>> list = k1.getCommonSupertypeWith(k2);
            boolean foundClass = false;
            for (Class<?> c : list) {
                if (!new Kelas(c).isInterface()) {
                    foundClass = true;
                    break;
                }
            }
            if (!foundClass) {
                //System.out.println(name1 + " and " + name2 + " both implement an interface.\n");
            }
        }
    }

    public static void mustHaveProperAbstractClassAsParent(String name1, String name2)
            throws ClassNotFoundException {
        // Check if common parent is a proper abstract class
        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);
        List<Class<?>> list = k1.getCommonSupertypeWith(k2);
        for (Class<?> c : list) {
            Kelas k = new Kelas(c);
            if (k.isAbstract()) {
                if (!k.hasAbstractMethods()) {
                    //System.out.println(k + ": is abstract but does not have any abstract method");
                }
            }
            return;
        }
    }

    public static void mustDeclareComputeFareOrConfigureParent(String name)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        if (k.hasPublicMethod("computeFare", Class.forName("Request"))) {
            return;
        } else {
            //System.out.println(name + ": no computeFare(). Parent's constructors:");
            Constructor<?>[] cs = Class.forName(name).getSuperclass().getDeclaredConstructors();
            for (Constructor<?> c : cs) {
                //System.out.println(" - " + c);
            }
        }
    }

    public static void mustDefineConstantWithValue(String name, int n)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        if (!k.hasPublicConstantFieldWithTypeValue(int.class, n)) {
            //System.out.println(name + " does not have a const with value " + n);
        }
    }

    public static void mustDefinePublicIntConstantWithValues(String name, int... values)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        boolean found = false;
        String msg = name + ": no const with value(s) ";
        for (int i : values) {
            if (!k.hasPublicConstantFieldWithTypeValue(int.class, i)) {
                msg += i + ", ";
                found = true;
            }
        }
        if (found) {
            msg = msg.substring(0, msg.length() - 2);
            //System.out.println(msg+"\n");
        }
    }

    public static void mustDefinePrivateIntConstantWithValues(String name, int... values)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        boolean found = false;
        String msg = name + " should include private static final field(s) with value(s): " ;
        for (int i : values) {
            if (!k.hasPrivateConstantFieldWithTypeValue(Integer.class, i))  { 
                msg += i + ", ";
                found = true;
            }
        }
        if (found) {
            msg = msg.substring(0, msg.length() - 2);
            msg += ". Use a private static final field for constant values instead of hardcoding them as magic numbers.\n";
            //System.out.println(msg);
        }
    }

    public static Boolean mustImplementOneOfGenericInterfaces(String name, String... intfNames)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        boolean found = false;
        for (String intfName : intfNames) {
            if (k.doesImplementGenericInterface(intfName)) {
                found = true;
                break;
            }
        }
        if (!found) {
            //System.out.println("The class " + name + " does not implement one of:");
            for (String intfName : intfNames) {
                //System.out.println(" - " + intfName);
            }
        }
        return found;
    }
    
    public static Boolean mustDefineNFieldsOfType(String className, String fieldClassName, int n)
            throws ClassNotFoundException {
        Kelas k = new Kelas(className);
        try {
            Class fieldType =  Class.forName(fieldClassName);
            int fieldCount = k.numberOfFieldsWithType(fieldType);
            if (fieldCount != n) {
                //System.out.println(String.format("Expected %d fields of type %s in %s, only found %d field(s).\n",n,fieldType,className,fieldCount));
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false; // Class not found
        }
    }
    
    public static Boolean mustDefineNFieldsOfType(String className, Class fieldClass, int n)
            throws ClassNotFoundException {
        Kelas k = new Kelas(className);
        int fieldCount = k.numberOfFieldsWithType(fieldClass);
        if (fieldCount != n) {
            //System.out.println(String.format("Expected %d fields of type %s in %s, only found %d field(s).\n",n,fieldClass,className,fieldCount));
            return false;
        }
        return true;
    }
    
    public static Boolean mustDefineEnumField(String className)
            throws ClassNotFoundException {
        Kelas k = new Kelas(className);
        return k.hasEnumFields();
    }
}
