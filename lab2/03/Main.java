import java.util.Scanner;

/*
    You might wanna google the API for List and ArrayList! 
    I think I have told it to your friend Kelvin about it already! 
    It'll help a lot for future labs!
*/
class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfCruises = scan.nextInt();
        Cruise[] cruises = new Cruise[numOfCruises];
        for (int i = 0; i < numOfCruises; i++) {
            String cruiseID = scan.next();
            if(cruiseID.charAt(0) == 'B') {
                cruises[i] = new BigCruise(cruiseID, scan.nextInt(), scan.nextInt(), scan.nextInt());
            }
            if(cruiseID.charAt(0) == 'S') {
                cruises[i] = new SmallCruise(cruiseID, scan.nextInt());
            }
        }
        int index = 1;
        Loader[] listOfLoaders = new Loader[270];
        for (int i = 0; i < numOfCruises; i++) {
            int counter = 0;
            for (int j = 0; j < 270; j++) {
                if (listOfLoaders[j] == null) {
                    listOfLoaders[j] = new Loader(index);
                    index++;
                }
                if (cruises[i].getNumOfLoadersRequired() == counter) {
                    break;
                }
               
                if (listOfLoaders[j].canServe(cruises[i])) {
                    listOfLoaders[j] =  listOfLoaders[j].serve(cruises[i]);
                    System.out.println(listOfLoaders[j]);
                    counter++;
                }

            }
        }

    }

}

