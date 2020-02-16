import java.util.Scanner;

public class Main {

    public static boolean isBigCruiseID(String id) {
        return id.charAt(0) == 'B';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CruiseTerminal cruiseTerminal = new CruiseTerminal();

        int cruises = sc.nextInt();

        for (int c = 0; c < cruises; c++) {
            String id = sc.next();
            int arrivalTime = sc.nextInt();

            if (isBigCruiseID(id)) {
                int length = sc.nextInt();
                int passengers = sc.nextInt();

                Cruise cruise = new BigCruise(id, arrivalTime, length, passengers);
                cruiseTerminal.loadCruise(cruise);
            } else {
                Cruise cruise = new SmallCruise(id, arrivalTime);
                cruiseTerminal.loadCruise(cruise);
            }
        }

        cruiseTerminal.printStatuses();
    }
}