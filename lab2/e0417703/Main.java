import java.util.Scanner;
import java.util.Vector;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cruise[] cruises = new Cruise[n];

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            int arrivalTime = sc.nextInt();
            switch (id.charAt(0)) {
                case 'B':
                    int cruiseLength = sc.nextInt();
                    int numPassengers = sc.nextInt();
                    cruises[i] = new BigCruise(id, arrivalTime, cruiseLength, numPassengers);
                    break;

                case 'S':
                    cruises[i] = new SmallCruise(id, arrivalTime);
                    break;

                default: 
                    break;
            }
        }
        sc.close();

        Vector<Loader> loaders = new Vector<Loader>();
        for (Cruise cruise : cruises) {
            int loadersNeeded = cruise.getNumOfLoadersRequired();
            int i = 0;

            // Use as many loaders as are available
            while (loadersNeeded > 0 && i < loaders.size()) {
                Loader loader = loaders.get(i);
                if (loader.canServe(cruise)) {
                    // immutable loaders
                    Loader updatedLoader = loader.serve(cruise);
                    loaders.set(i, updatedLoader);
                    System.out.println(updatedLoader);
                    loadersNeeded--;
                }
                i++;
            }
            
            // Purchase remaining loaders
            while (loadersNeeded > 0) {
                Loader loader = new Loader(loaders.size() + 1).serve(cruise);
                loaders.add(loader);
                System.out.println(loader);
                loadersNeeded--;
            }
        }
    }
}