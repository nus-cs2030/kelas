class BigCruise extends Cruise {

    final static int PASSENGERS_PER_MIN = 50;
    final static int LENGTH_PER_LOADER = 40;

    BigCruise(String id, int arrivalTime, int length, int numOfPassengers) {
        super(id, arrivalTime,
                (int) Math.ceil(length * 1.0 / LENGTH_PER_LOADER),
                (int) Math.ceil(numOfPassengers * 1.0 / PASSENGERS_PER_MIN));
    }
}
