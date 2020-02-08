import java.util.Scanner;
import java.util.ArrayList;

class Main6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int noOfCruises = scan.nextInt();
        int numberOfLoader = 1;

        ArrayList<Loader> loaders = new ArrayList<Loader>(0);
        Cruise[] cruises = new Cruise [noOfCruises];
        int[] loadersNeeded = new int [noOfCruises];

        for (int i = 0; i < noOfCruises; i++) {
            String identifier = scan.next();
            if (identifier.charAt(0) == 'S') {
                int arrival = scan.nextInt();
                cruises[i] = new SmallCruise(identifier, arrival);
                loadersNeeded[i] = 1;
            } else {
                int arrival = scan.nextInt();
                int length = scan.nextInt();
                int customers = scan.nextInt();

                cruises[i] = new BigCruise(identifier, arrival, length, customers);
                loadersNeeded[i] = (int) Math.ceil((float) length / 40);

            }
        }

        for (int i = 0; i < noOfCruises; i++) {
            int loadersLeft;
            if (loadersNeeded[i] > 9) {
                loadersLeft = 9;
            } else {
                loadersLeft = loadersNeeded[i];
            }

            for (int j = 0; loadersLeft != 0; j++) {
                if (j == loaders.size()) {
                    loaders.add(new LoaderRecycled(numberOfLoader));
                    numberOfLoader += 1;
                }
                if (loaders.get(j).canServe(cruises[i])) {
                    loaders.set(j, loaders.get(j).serve(cruises[i]));
                    System.out.println(loaders.get(j));
                    loadersLeft -= 1;
                }

            }
        }
    }

}
