import java.util.ArrayList;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args){

        //Scanner a = new Scanner(System.in);
        //int cruiseNum = a.nextInt();
        Scanner sc = new Scanner(System.in);
        int cruiseNum = sc.nextInt();

        Cruise[] cruises = new Cruise[cruiseNum];
        for(int i = 0; i < cruiseNum; i++){
            String identity = sc.next();
            Cruise cruise = null;
            if(identity.charAt(0) == 'B'){
                String arrivalTimeString = sc.next();
                int arrivalTime = Integer.parseInt(arrivalTimeString);
                String lengthString = sc.next();
                int length = Integer.parseInt(lengthString);
                String numOfPassengersString = sc.next();
                int numOfPassengers = Integer.parseInt(numOfPassengersString);
                cruise = new BigCruise(identity, arrivalTime, length, numOfPassengers);
            }
            else if(identity.charAt(0) == 'S'){
                String arrivalTimeString = sc.next();
                int arrivalTime = Integer.parseInt(arrivalTimeString);
                cruise = new SmallCruise(identity, arrivalTime);
            }
            cruises[i] = cruise;
        }

        //Scanning the whole line method
//
//        String [] cruiseStrings = new String[cruiseNum];
//        for(int i = 0; i < cruiseNum; i++){
//            //System.out.println(i + "th line");
//            cruiseStrings[i] = sc.nextLine();
//        }
//
//        //check cruise String array
////        for(int i = 0; i < cruiseNum; i++){
////            System.out.println(cruiseStrings[i]);
////        }
//
//        for(int i = 0; i < cruiseNum; i++){
//            String[] c = cruiseStrings[i].split("\\s+");
//            if(c.length == 2){
//                cruises[i] = new SmallCruise(c[0], Integer.parseInt(c[1]));
//            }else if(c.length == 4){
//                cruises[i] = new BigCruise(c[0], Integer.parseInt(c[1]), Integer.parseInt(c[2]), Integer.parseInt(c[3]));
//            }
//        }

        //Check cruise array
//        System.out.println("Checking Cruise Array: ");
//        for(int i = 0; i< cruiseNum; i++){
//            System.out.println(cruises[i]);
//        }

        int loaderCounter = 0;
        ArrayList<Loader> loaders = new ArrayList<Loader>();

        //Check loadersArray
//        for(int i = 0; i < loaders.length && loaders[i] != null; i++){
//            System.out.println(loaders[i]);
//        }
        //System.out.println(cruises[1].getServiceCompletionTime());

        for (Cruise cruise : cruises) {
            int loadersRequired = cruise.getNumOfLoadersRequired();
            int loadersGotten = 0;
//            System.out.println("Enhanced cruise loop entered");
//            System.out.println("Displaying all loaders status: ");
//            for(Loader loader: loaders){
//                System.out.println(loader);
//            }
            for (int j = 0; j < loaders.size()  && loadersGotten != loadersRequired; j++) {
                if(loaders.get(j).canServe(cruise)){
                    Loader l = loaders.get(j);
                    loaders.remove(j);
                    loaders.add(j, l.serve(cruise));
                    loadersGotten++;
                    System.out.println(loaders.get(j));
                }
            }

            while(loadersGotten < loadersRequired){
                //System.out.println("not enough loaders, purchasing new ones");
                Loader l;
                if(loaders.size() % 3 == 2) {
                    l = new RecycledLoader(loaders.size() + 1).serve(cruise);
                }else{
                    l = new Loader(loaders.size() + 1).serve(cruise);
                }
                loaders.add(l);
                System.out.println(l);
                loadersGotten++;
            }
        }


    }
}


