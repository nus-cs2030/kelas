import java.util.List;

/*
   - Cruise
   - [x] must contain only private and final fields

   - Loader
   - [x] must contain only private and final fields
   - [x] must contain one instance of serve method only (no overloading)
   - [x] must contain one instance of canServe method only (no overloading)

   - SmallCruise
   - [x] must inherit from Cruise
   - [x] must contain one "private final static" field with value 1
   - [x] must contain one "private final static" field with value 30

   - BigCruise
   - [x] must inherit from Cruise
   - [x] must contain one "private final static" field with value 40 or 40.0
   - [x] must contain one "private final static" field with value 50 or 50.0
   */

class CheckDesign {

    public static void main(String[] args) {
        List<String> classes = List.of(
                "Cruise",
                "BigCruise",
                "SmallCruise",
                "Loader");

        // Preliminary checks
        // Pakej.checkIfClassesExist(classes);

        // Main checks
        try {
            // Cruise
            Kelas cruise = new Kelas("Cruise");
            if (cruise.getFields().arePrivate(true).areFinal(true).count() != cruise.getFields().count()) {
                System.out.println("Cruise contains fields that are not private AND final");
            }

            if (!KelasUtils.checkCommonParent("SmallCruise", "BigCruise").passed()) {
                if (!KelasUtils.checkChildOf("SmallCruise","Cruise").passed()) {
                    System.out.println("SmallCruise and BigCruise do not have Cruise as common parent");
                }
            }

            // Pakej.mustHavePrivateAndFinalFields("Cruise");
            // Pakej.mustHaveCommonParent("SmallCruise", "BigCruise");

            // // Loader
            // Pakej.mustHavePrivateAndFinalFields("Loader");
            // Pakej.mustNotHaveExtraMethods("Loader", "serve", "canServe");

            // // SmallCruise
            // Pakej.mustBeChildOf("SmallCruise", "Cruise");
            // Pakej.mustDefinePrivateIntConstantWithValues("SmallCruise", 1, 30);

            // // BigCruise
            // Pakej.mustBeChildOf("BigCruise", "Cruise");
            // Pakej.mustDefinePrivateIntConstantWithValues("BigCruise", 40, 50);
        } catch (ClassNotFoundException e) {
            // System.out.println(e);

        }

    }
}
