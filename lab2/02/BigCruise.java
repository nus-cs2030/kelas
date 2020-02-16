public class BigCruise extends Cruise {

    private int length;
    private int passengers;

    private static final double METERS_PER_LOADER = 40.0;
    private static final double MINUTE_PER_PASSENGERS = 50.0;

    public BigCruise(String id, int arrivalTime, int length, int passengers) {
        super(id, arrivalTime, 
            (int) Math.ceil(length / METERS_PER_LOADER), 
            (int) Math.ceil(passengers / MINUTE_PER_PASSENGERS));
    }

    @Override
    public boolean isBigCruise() {
        return true;
    }
}