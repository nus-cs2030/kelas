class BigCruise extends Cruise {
    public BigCruise(String id, int arrivalTime, int cruiseLength, int numPassengers) {
        // Uses ceiling division algorithm for integers
        super(id, 
                arrivalTime, 
                (cruiseLength / 40) + ((cruiseLength % 40 == 0) ? 0 : 1), 
                (numPassengers / 50) + ((numPassengers % 50 == 0) ? 0 : 1));
    }
}