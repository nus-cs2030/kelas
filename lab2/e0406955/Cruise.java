class Cruise {
    private final String ID;
    private final int arrivalTime;
    private final int loaders;
    private final int serviceTime;

    Cruise(String ID, int arrivalTime, int loaders, int serviceTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.loaders = loaders;
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        int TimeInMinutes = this.arrivalTime/100*60 + this.arrivalTime%100;
        return TimeInMinutes;
    }

    public int getNumOfLoadersRequired() {
        return this.loaders;
    }

    public int getServiceCompletionTime() {
        return getArrivalTime() + this.serviceTime;
    }

    @Override
    public String toString() {
        return this.ID + "@" + String.format("%04d", this.arrivalTime);
    }
}
