import java.util.Scanner;

class Main6 {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                int cruiseNum = scan.nextInt();
                Cruise[] cruises = new Cruise[cruiseNum];
                for (int i = 0; i < cruiseNum; i++) {
                        String CruiseID = scan.next();
                        if(CruiseID.charAt(0) == 'S') {
                                cruises[i] = new SmallCruise(CruiseID, scan.nextInt());
                        }
                        if(CruiseID.charAt(0) == 'B'){
                                cruises[i] = new BigCruise(CruiseID, scan.nextInt(), scan.nextInt(), scan.nextInt());
                        }
                }


                Loader[] listOfLoaders = new Loader[270];
                int index = 1;

                for (int i = 0; i < cruiseNum; i++) {
                        int counter = 0;
                        for (int j = 0; j < 270; j++) {
                                if (listOfLoaders[j] == null) {
                                        listOfLoaders[j] = new Loader(index);
                                        index++;
                                }

                                if (cruises[i].getNumOfLoadersRequired() == counter) {
                                        break;
                                }

                                if (listOfLoaders[j].getID() % 3 == 0){
                                        Cruise cruise = new Cruise(cruises[i].getID(),
                                                        cruises[i].getTime(),
                                                        1 , 
                                                        cruises[i].getServiceTime() + 60);

                                        if(listOfLoaders[j].canServe(cruise)){
                                                listOfLoaders[j] = listOfLoaders[j].serve(cruise);
                                                System.out.println("Loader " + listOfLoaders[j].getID()+
                                                                " (recycled) serving " + cruises[i]);
                                                counter++;
                                                continue;
                                        }
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

