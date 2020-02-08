import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

/*
   - Cruise
   - [x] must contain only private and final fields

   - Loader
   - [x] must contain only private and final fields
   - [x] must contain one instance of serve method only (no overloading)
   - [x] must contain one instance of canServe method only (no overloading)

   - SmallCruise
   - [x] must inherit from Cruise
   - [ ] must contain one "private final static" field with value 1
   - [ ] must contain one "private final static" field with value 30

   - BigCruise
   - [x] must inherit from Cruise
   - [ ] must contain one "private final static" field with value 40 or 40.0
   - [ ] must contain one "private final static" field with value 50 or 50.0
   */

class CheckDesign {

	public static void main(String[] args) {
		List<String> classes = List.of(
				"Cruise",
				"BigCruise",
				"SmallCruise",
				"Loader");

    // Preliminary checks
    Pakej.checkIfClassesExist(classes);

    // Main checks
    try {
		// Cruise
		Pakej.mustHavePrivateAndFinalFields("Cruise");
		Pakej.mustHaveCommonParent("SmallCruise", "BigCruise");

		// Loader
		Pakej.mustHavePrivateAndFinalFields("Loader");
		Pakej.mustNotHaveExtraMethods("Loader", "serve", "canServe");

		// SmallCruise
		Pakej.mustBeChildOf("SmallCruise", "Cruise");
        Pakej.mustDefineConstantWithValue("SmallCruise", 1, 30);

		// BigCruise
		Pakej.mustBeChildOf("BigCruise", "Cruise");
        Pakej.mustDefineConstantWithValue("BigCruise", 40, 50);
    } catch (ClassNotFoundException e) {

    }

	}
}