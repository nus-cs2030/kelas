class BigCruise extends Cruise {
    protected final int length;
    protected final int passengers;

    BigCruise(String identifier, int arrivalTime, int length, int passengers) {
        super(identifier, arrivalTime, (int)Math.ceil(length / 40.0), (int)Math.ceil(passengers / 50.0));
        this.length = length;
        this.passengers = passengers;

    }
}
