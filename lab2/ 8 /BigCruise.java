class BigCruise extends Cruise {
    final float length;
    final float customers;

    public BigCruise(String identifier, int arrival, int length, int customers) {
        super(identifier, arrival, 
                (int) Math.ceil((float) length / 40), (int) Math.ceil((float) customers / 50));
        this.length = length;
        this.customers = customers;
    }
}
