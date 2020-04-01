package midterm;

import java.util.List;


/*
   - Case
   - [x] must contain one int field
 
   - ImportedCase
   - [x] must inherit from Case
   - [x] must contain one string field
 
   - Contact
   - [x] must contain one field of type string or int or enum or Country
   - [x] must contain two Case fields
 
   - Cluster:
   - [x] must contain one string field
   - [x] must contain Collection of Case field
 
 or
 
   - Case
   - [x] must contain one int field
 
   - ImportedCase
   - [x] must inherit from Case
   - [x] must contain one string field
 
   - Contact
   - [x] must contain one field of type string or int or enum or Country
   - [x] must contain two Case fields
 
   - Cluster:
   - [x] must contain one string field
 
   - There exists a CompositionClass
   - [x] must contain one Cluster fields
   - [x] must contain Collection<Case> or Map field
*/

class CheckDesign2 {
    
    public static void main(String[] args) {
        Boolean success = false;

        List<String> classes = List.of(
                "Case",
                "ImportedCase",
                "Contact",
                "Cluster");
        
        Boolean clusterCheck = Boolean.valueOf(args[0]);
        Boolean compositionCheck = Boolean.valueOf(args[1]);

        // Preliminary checks
        success = KelasUtils.checkIfClassesExist(classes).passed();

        if (!success) {
            System.exit(1);
        }
        success = true;

        // Check Design 1
        try {
            // Case
            Kelas caseClass = new Kelas("Case");
            success &= caseClass.getFields().arePublic(false).haveType(int.class).countEquals(1) 
                    ^  caseClass.getFields().arePublic(false).haveType(java.lang.Integer.class).countEquals(1);


            success &= (Pakej.mustDefineNFieldsOfType("Case",int.class,1) ^ Pakej.mustDefineNFieldsOfType("Case","java.lang.Integer",1));

            // ImportedCase
            success &= Pakej.mustBeChildOf("ImportedCase", "Case");
            success &= (Pakej.mustDefineNFieldsOfType("ImportedCase","java.lang.String",1) ^ Pakej.mustDefineNFieldsOfType("ImportedCase","Country",1));

            // Contact
            success &= Pakej.mustDefineNFieldsOfType("Contact","Case",2);
            success &= (Pakej.mustDefineNFieldsOfType("Contact",int.class,1) ^ Pakej.mustDefineNFieldsOfType("Contact",int.class,4) ^ Pakej.mustDefineNFieldsOfType("Contact","java.lang.String",1) ^ Pakej. mustDefineEnumField("Contact"));

            // Cluster
            success &= Pakej.mustDefineNFieldsOfType("Cluster","java.lang.String",1);
            //- [x] must contain Collection of Case field
            success &= clusterCheck;
            
        } catch (ClassNotFoundException e) {

        }

        if (success) {
            System.out.println("Success");
            System.exit(0);
        }

        success = true;
        
        // Check Design 2
        try {
            // Case
            success &= (Pakej.mustDefineNFieldsOfType("Case",int.class,1) ^ Pakej.mustDefineNFieldsOfType("Case","java.lang.Integer",1));
            
            // ImportedCase
            success &= Pakej.mustBeChildOf("ImportedCase", "Case");
            success &= (Pakej.mustDefineNFieldsOfType("ImportedCase","java.lang.String",1) ^ Pakej.mustDefineNFieldsOfType("ImportedCase","Country",1));

            // Contact
            success &= Pakej.mustDefineNFieldsOfType("Contact","Case",2);
            success &= (Pakej.mustDefineNFieldsOfType("Contact",int.class,1) ^ Pakej.mustDefineNFieldsOfType("Contact",int.class,4) ^ Pakej.mustDefineNFieldsOfType("Contact","java.lang.String",1) ^ Pakej.mustDefineEnumField("Contact"));

            // Cluster
            success &= Pakej.mustDefineNFieldsOfType("Cluster","java.lang.String",1);

            //- CompositionClass
            //- There exists a CompositionClass
            //- [x] must contain one Cluster fields
            //- [x] must contain Collection<Case> or Map field
            success &= compositionCheck;

        } catch (ClassNotFoundException e) {

        }
        if (success) {
            System.out.println("Success");
            System.exit(0);
        }
        
        if (!success) {
            System.out.println("Your design did not pass the auto-grader. Please revisit the question");
            System.exit(1);
        }

    }
}
