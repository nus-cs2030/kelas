import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;

class KelasUtils {

    /**
     * Check if classes exist
     *
     * @param classes List<String> of class names to check for existence
     * @throws ClassNotFoundException Thrown if the class is not valid.
     */
    public static Check checkClassesExist(List<String> classes) {
        Boolean allClassesFound = true;
        String notFoundName = "";
        for (String name : classes) {
            try {
                new Kelas(name);
            } catch (ClassNotFoundException e) {
                allClassesFound = false;
                notFoundName = name;
            }
        }
        return new Check(allClassesFound, "Class not found: " + notFoundName);
    }

    /**
     * Check for common parent
     */
    public static Check checkCommonParent(String name1, String name2)
            throws ClassNotFoundException {
        Boolean pass = false;

        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);
        if (!k1.shareCommonSupertypeWith(k2)) {
            pass = true;
        }

        return new Check(pass, name1 + " & " + name2 + " do not have common parent.");
    }

    /**
     * Check for child
     */
    public static Check checkChildOf(String child, String parent) throws ClassNotFoundException {
        Kelas k1 = new Kelas(child);
        Boolean isChildOf = k1.isChildOf(parent);

        return new Check(isChildOf, child + " does not inherit from " + parent + ".");
    }

    public static Check mustNotHaveOnlyInterfaceAsParent(String name1, String name2)
    throws ClassNotFoundException {
        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);

        boolean foundClass = false;
        if (k1.shareCommonSupertypeWith(k2)) {
            // Check if common parent of cab and car consists of only interfaces (should not)
            List<Class<?>> list = k1.getCommonSupertypeWith(k2);
            for (Class<?> c : list) {
                if (!new Kelas(c).isInterface()) {
                    foundClass = true;
                    break;
                }
            }
        }
        return new Check(foundClass, name1 + " and " + name2 + " both implement an interface.");
    }

    public static void mustHaveProperAbstractClassAsParent(String name1, String name2)
            throws ClassNotFoundException {
        // Check if common parent is a proper abstract class
        Kelas k1 = new Kelas(name1);
        Kelas k2 = new Kelas(name2);
        List<Class<?>> list = k1.getCommonSupertypeWith(k2);
        boolean pass;
        for (Class<?> c : list) {
            Kelas k = new Kelas(c);
            if (k.isAbstract()) {
                if (!k.hasAbstractMethods()) {
                    //System.out.println(k + ": is abstract but does not have any abstract method");
                }
            }
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
}
