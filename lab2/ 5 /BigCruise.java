class BigCruise extends Cruise {

    public BigCruise(String id, int arrivalTime, int length, int numOfPassengers) {
        super(id, arrivalTime, (int) Math.ceil((double) length/40), (int) Math.ceil((double) numOfPassengers/50));
    }
}
