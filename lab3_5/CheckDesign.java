import java.util.List;

/*
    - Cuboid
        - [x] Shares common abstract class/interface with Sphere
        - [x] No public/default access modifier for fields

    - Sphere
        - [x] Shares common abstract class/interface with Cuboid
        - [x] No public/default access modifier for fields

    - No SolidSphere/SolidCuboid 
*/

class CheckDesign {

    public static void main(String[] args) {
        List<String> classes = List.of(
                "Cuboid",
                "Sphere");

        List<String> unwantedClasses = List.of(
                "SolidSphere",
                "SolidCuboid");

        // Preliminary checks
        Pakej.checkIfClassesExist(classes);
        Pakej.checkIfClassesDoNotExist(unwantedClasses);

        // Main checks
        try {
            Pakej.checkPublicFields(classes);
            Pakej.checkDefaultFields(classes);

            // Sphere & Cuboid
            Pakej.mustHaveProperAbstractClassAsParent("Sphere", "Cuboid");
        } catch (ClassNotFoundException e) {
        }
    }
}
