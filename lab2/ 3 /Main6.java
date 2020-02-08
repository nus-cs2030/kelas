import java.util.Scanner;

class Main6 {

    public static boolean divisibleBy3(int x) {
        return x % 3 == 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cruiseNum = sc.nextInt();
        Cruise[] cruiseList = new Cruise[cruiseNum];

        for(int i = 0; i < cruiseList.length; i++) {
            String id = sc.next();
            if (id.charAt(0) == 'B') {
                cruiseList[i] = new BigCruise(id, sc.nextInt(), sc.nextInt(), sc.nextInt()); 
            } else if (id.charAt(0) == 'S') {
                cruiseList[i] = new SmallCruise(id, sc.nextInt());
            } else {
                continue;
            }
        }

        Loader[] loaderList = new Loader[cruiseNum * 9];

        for(Cruise cruise : cruiseList) {
            int loadersReq = cruise.getNumOfLoadersRequired();

            for(int i = 0; i < loadersReq; i++) {
                boolean checkAvail = false;
                int count = 0;
                while(!checkAvail) {
                    if(loaderList[count] == null || loaderList[count].canServe(cruise)) {
                        if (divisibleBy3(count + 1)) {
                            loaderList[count] = new RecycledLoader(count + 1).serve(cruise);
                            System.out.println(loaderList[count]);
                            checkAvail = true;
                        } else {
                            loaderList[count] = new Loader(count + 1).serve(cruise);
                            System.out.println(loaderList[count]);
                            checkAvail = true;
                        }
                    } else {
                        count++;
                    }
                }
            }
        }
    }
}

