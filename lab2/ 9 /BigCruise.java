import java.lang.Math;

public class BigCruise extends Cruise {
    public BigCruise(String identity, int timeOfArrival, double length, double passengers) {
        super(identity, timeOfArrival,
             (int) Math.ceil(length / 40),
             (int) Math.ceil(passengers / 50));
    }
}