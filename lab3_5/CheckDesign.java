import java.util.List;

/*
   - SolidCuboid
   - [x] Extends from Cuboid
   - [x] No public/default access modifier for fields

   - SolidSphere
   - [x] Extends from Sphere
   - [x] No public/default access modifier for fields

   - SolidCuboid and SolidSphere
   - [ ] Both share a common abstract Class
   - [ ] Both share another common interface
*/

class CheckDesign {

    public static void main(String[] args) {
        List<String> classes = List.of(
                "SolidCuboid",
                "SolidSphere");

        // Preliminary checks
        Pakej.checkIfClassesExist(classes);

        // Main checks
        try {
            Pakej.checkPublicFields(classes);
            Pakej.checkDefaultFields(classes);

            // SolidCuboid
            Pakej.mustBeChildOf("SolidCuboid", "Cuboid");

            // SolidSphere
            Pakej.mustBeChildOf("SolidSphere", "Sphere");
        } catch (ClassNotFoundException e) {

        }

    }
}
