import java.util.Scanner;
import java.util.ArrayList;

class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numOfCruises = reader.nextInt();
        Cruise[] cruises = new Cruise[numOfCruises];
        ArrayList<Loader> loaders = new ArrayList<Loader>();

        // Used to assign ids
        int loaderCount = 1;
        loaders.add(new Loader(loaderCount));
        loaderCount++;

        // Get user input
        for (int i = 0; i < numOfCruises; i++) {
            String id = reader.next();
            if (id.charAt(0) == 'S') {
                int arrivalTime = reader.nextInt();
                cruises[i] = new SmallCruise(id, arrivalTime);
            } else {
                int arrivalTime = reader.nextInt();
                int length = reader.nextInt();
                int passengers = reader.nextInt();
                cruises[i] = new BigCruise(id, arrivalTime, length, passengers);
            }
        }

        for (Cruise cruise : cruises) {
            // Check if there are enough loaders in the first place to service the cruise.
            // If not, add until there is enough
            for (int j = loaders.size(); j < cruise.getNumOfLoadersRequired(); j++) {
                // This "if" is for level 6
                if ((args.length != 0) && (loaderCount % 3 == 0)) {
                    loaders.add(new RecycledLoader(loaderCount));
                    loaderCount++;
                } else {
                    loaders.add(new Loader(loaderCount));
                    loaderCount++;
                }
            }
            // Create variable to check if cruise is served by the correct amount of loaders
            int served = 0;

            // Loop through all the loaders and check if they can service the cruise.
            // Stop once we exceeded the ArrayList size or when the cruise doesn't need more
            // loaders
            for (int k = 0; k < loaders.size() && served < cruise.getNumOfLoadersRequired(); k++) {
                if (loaders.get(k).canServe(cruise)) {
                    // Update the ArrayList with the latest info from the loaders
                    loaders.set(k, loaders.get(k).serve(cruise));
                    served++;
                    System.out.println(loaders.get(k));
                }
            }

            // If the loaders in the ArrayList couldn't serve the cruise, then we create new
            // loaders to serve the cruise
            while (served < cruise.getNumOfLoadersRequired()) {
                // This "if" is for level 6
                if ((args.length != 0) && (loaderCount % 3 == 0)) {
                    RecycledLoader loader = new RecycledLoader(loaderCount);
                    loader = loader.serve(cruise);
                    loaders.add(loader);
                    loaderCount++;
                    served++;
                    System.out.println(loader);
                } else {
                    Loader loader = new Loader(loaderCount);
                    loader = loader.serve(cruise);
                    loaders.add(loader);
                    loaderCount++;
                    served++;
                    System.out.println(loader);
                }
            }
        }
    }
}
