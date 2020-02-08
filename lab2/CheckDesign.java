import java.util.List;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

/*
   - Cruise
   - [ ] must contain only private fields
   - [ ] must contain only final fields

   - Loader
   - [ ] must not contain public members
   - [ ] must contain only final fields
   - [ ] must contain one instance of serve method only (no overloading)
   - [ ] must contain one instance of canServe method only (no overloading)

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
    Pakej.checkPublicFields(classes);

    //
    try {
        Pakej.mustHaveCommonParent("SmallCruise", "BigCruise");
        Pakej.mustBeChildOf("SmallCruise", "Cruise");
        Pakej.mustBeChildOf("BigCruise", "Cruise");
    } catch (ClassNotFoundException e) {

    }

	}
}
