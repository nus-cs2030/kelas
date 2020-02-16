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
    public static void checkIfClassesExist(List<String> classes) {
        for (String name : classes) {
            try {
                new Kelas(name);
            } catch (ClassNotFoundException e) {
                System.out.println(name + ": not found");
            }
        }
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
                    System.out.println(name + ": contains public fields:");
                    for (Field f : kelas.getPublicFields()) {
                        System.out.println(" - " + f);
                    }
                }
            } catch (ClassNotFoundException e) {
            }
        }
    }

    public static void checkDefaultFields(List<String> classes) {
        for (String name : classes) {
            try {
                Kelas kelas = new Kelas(name);
                if (kelas.containsDefaultFields()) {
                    System.out.println(name + ": contains default fields:");
                    for (Field f : kelas.getDefaultFields()) {
                        System.out.println(" - " + f);
                    }
                }
            } catch (ClassNotFoundException e) {
            }
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
                System.out.println(name + ": contains non private or non final fields:");
                for (Field f : list) {
                    System.out.println(" - " + f);
                }
            }

        } catch (ClassNotFoundException e) {
        }
    }

    public static void mustHaveCommonParent(String name1, String name2)
            throws ClassNotFoundException {
        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);
        if (!k1.shareCommonSupertypeWith(k2)) {
            System.out.println(name1 + " and " + name2 + " do not have common parent.");
        }
    }

    public static void mustBeChildOf(String child, String parent) throws ClassNotFoundException {
        Kelas k1 = new Kelas(child);
        if (!k1.isChildOf(parent)) {
            System.out.println(child + " does not inherit from " + parent);
        }
    }

    public static void mustNotHaveExtraMethods(String className, String... methodNames)
            throws ClassNotFoundException {
        Kelas k1 = new Kelas(className);
        String msg = className + ": have extra methods:\n";
        boolean extra = false;
        for (String name : methodNames) {
            boolean found = false;
            for (Method m : k1.getMethods()) {
                if (m.getName().equals(name)) {
                    if (found) {
                        msg += " - " + m + "\n";
                        extra = true;
                    }
                    found = true;
                }
            }
        }
        if (extra) {
            System.out.println(msg);
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
                System.out.println(name1 + " and " + name2 + " both implement an interface.");
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
                    System.out.println(k + ": is abstract but does not have any abstract method");
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
            System.out.println(name + ": no computeFare(). Parent's constructors:");
            Constructor<?>[] cs = Class.forName(name).getSuperclass().getDeclaredConstructors();
            for (Constructor<?> c : cs) {
                System.out.println(" - " + c);
            }
        }
    }

    public static void mustDefineConstantWithValue(String name, int n)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        if (!k.hasPublicConstantFieldWithTypeValue(int.class, n)) {
            System.out.println(name + " does not have a const with value " + n);
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
            System.out.println(msg);
        }
    }

    public static void mustDefinePrivateIntConstantWithValues(String name, int... values)
            throws ClassNotFoundException {
        Kelas k = new Kelas(name);
        boolean found = false;
        String msg = name + ": no const with value(s) ";
        for (int i : values) {
            if (!k.hasPrivateConstantFieldWithTypeValue(Integer.class, i)) {
                msg += i + ", ";
                found = true;
            }
        }
        if (found) {
            msg = msg.substring(0, msg.length() - 2);
            System.out.println(msg);
        }
    }

    public static void mustImplementOneOfGenericInterfaces(String name, String... intfNames)
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
            System.out.println(name + " does not implement one of:");
            for (String intfName : intfNames) {
                System.out.println(" - " + intfName);
            }
        }
    }
}
