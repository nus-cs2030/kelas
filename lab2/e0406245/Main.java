import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static Cruise[] readCruises() { 
        Scanner sc = new Scanner(System.in);
        int numCruise = sc.nextInt();
        Cruise[] cruises = new Cruise[numCruise];
        for (int i = 0; i < numCruise; i++) {
            String id = sc.next();
            if (id.charAt(0) == 'S') {
                cruises[i] = new SmallCruise(id, sc.nextInt());
            } else {
                cruises[i] = new BigCruise(id, sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        }
        return cruises;
    }  
    
    public static void serveCruise (Cruise[] cruises) {
        Loader[] loaders = new Loader[9 * cruises.length];
        int[] loadersPerCruise = new int[cruises.length]; 

        for (int x = 0; x < cruises.length; x++) {
            loadersPerCruise[x] = cruises[x].getNumOfLoadersRequired();
        }

        int numOfLoaders = 0;
        for (int i = 0; i < cruises.length; i++) {
            int k = loadersPerCruise[i];
            while (k > 0) {
                boolean haveLoader = false;
                for (int j = 0; j < numOfLoaders; j++) {
                    if (loaders[j].canServe(cruises[i])) {
                        loaders[j] = loaders[j].serve(cruises[i]);
                        System.out.println(loaders[j]);
                        haveLoader = true;
                        break;
                    } 
                } 
                if (haveLoader == false) {
                    loaders[numOfLoaders] = new Loader(numOfLoaders + 1, cruises[i]);
                    System.out.println(loaders[numOfLoaders].toString());
                    numOfLoaders++;
                }    
                k--;
            }    
        }
    }    
   
    public static void main(String[] args) {
        Cruise[] cruises = readCruises();
        serveCruise(cruises);
    }    
}