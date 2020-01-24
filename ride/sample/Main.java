import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dist = sc.nextInt();
        int num = sc.nextInt();
        int time = sc.nextInt();
        Request req = new Request(dist,num,time);
        ArrayList<Booking> book = new ArrayList<Booking>();
        while (sc.hasNext()) {
            String driver = sc.next();
            String plate = sc.next();
            int wait = sc.nextInt();
            if (driver.equals("NormalCab")) {
                book.add(new Booking(new NormalCab(plate,wait),new JustRide(),req));
                book.add(new Booking(new NormalCab(plate,wait),new TakeACab(),req));
            } else {
                book.add(new Booking(new PrivateCar(plate,wait),new JustRide(),req));
                book.add(new Booking(new PrivateCar(plate,wait),new ShareARide(),req));

            }
        }
        Collections.sort(book);
        for (Booking x: book) {
            System.out.println(x);
        }
    }
}
