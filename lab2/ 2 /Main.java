import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Cruise[] cruises = new Cruise[n];
        Loader[] loaders = new Loader[n * 9];
        int num = 0;    // number of loaders
        for(int i = 0; i < n; i++) {
            String id = scanner.next();
            if(id.substring(0, 1).equals("B")) {
                int arrival = scanner.nextInt();
                int length = scanner.nextInt();
                int passengers = scanner.nextInt();
                cruises[i] = new BigCruise(id, arrival, length, passengers);
            } else {
                int arrival = scanner.nextInt();
                cruises[i] = new SmallCruise(id, arrival);
            }
        }
        for(int i = 0; i < n; i++) {
            int required = cruises[i].getNumOfLoadersRequired();
            while(required > 0) {
                for(int j = 0; j < num; j++) {
                    if(loaders[j].canServe(cruises[i])) {
                        Loader temp = loaders[j].serve(cruises[i]);
                        loaders[j] = temp;
                        System.out.println(loaders[j].toString());
                        required--;
                    }
                    if(required == 0) {
                        break;
                    }
                }
                if(required > 0) {
                    loaders[num] = new Loader(num + 1);
                    num++;
                }
            }
        }
        scanner.close();
    }
}