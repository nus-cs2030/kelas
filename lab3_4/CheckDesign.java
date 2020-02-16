import java.util.List;

/*
    - Cuboid
        - [x] Shares common abstract class/interface with Sphere
        - [x] No public/default access modifier for fields

    - Sphere
        - [x] Shares common abstract class/interface with Cuboid
        - [x] No public/default access modifier for fields

    - SolidCuboid
        - [x] Extends from Cuboid
        - [x] No public/default access modifier for fields

    - SolidSphere
        - [x] Extends from Sphere
        - [x] No public/default access modifier for fields

    - SolidCuboid and SolidSphere
        - [x] Both share a common interface
*/

class CheckDesign {

    public static void main(String[] args) {
        List<String> classes = List.of(
                "Sphere",
                "Cuboid",
                "SolidCuboid",
                "SolidSphere");

        // Preliminary checks
        Pakej.checkIfClassesExist(classes);

        // Main checks
        try {
            Pakej.checkPublicFields(classes);
            Pakej.checkDefaultFields(classes);

            // Sphere & Cuboid
            Pakej.mustHaveProperAbstractClassAsParent("Sphere", "Cuboid");

            // SolidCuboid
            Pakej.mustBeChildOf("SolidCuboid", "Cuboid");

            // SolidSphere
            Pakej.mustBeChildOf("SolidSphere", "Sphere");
            
            // Check parents
            Pakej.mustHaveProperInterfaceAsParent("SolidSphere", "SolidCuboid");

        } catch (ClassNotFoundException e) {

        }

    }
}
