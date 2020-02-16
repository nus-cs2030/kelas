import java.util.List;

/*
    - Cuboid
        - [x] Shares common abstract class with Sphere
        - [x] No public/default access modifier for fields

    - Sphere
        - [x] Shares common abstract class with Cuboid
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
        Pakej.checkIfClassesDoNotExist(classes);

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
