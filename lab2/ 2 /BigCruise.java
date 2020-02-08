import java.lang.Math;
class BigCruise extends Cruise {
    public BigCruise(String id, int arrival, int length, int passengers) {
        super(id, arrival, (int)Math.ceil(length / 40.0), (int)Math.ceil(passengers / 50.0));
    }
} 