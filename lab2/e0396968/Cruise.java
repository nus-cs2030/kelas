class Cruise {
    protected final String identifier;
    protected final int arrivalTime;
    protected final int loaders;
    protected final int serviceTime;

    Cruise(String identifier, int arrivalTime, int loaders, int serviceTime) {
        this.identifier = identifier;
        this.arrivalTime = arrivalTime;
        this.loaders = loaders;
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        int hours = (this.arrivalTime) / 100;
        int mins = (this.arrivalTime) % 100;
        return hours * 60 + mins;
    }

    public int getNumOfLoadersRequired() {
        return this.loaders;
    }

    public int getServiceCompletionTime() {
        return this.getArrivalTime() + this.serviceTime;
    }

    public String toString() {
        return this.identifier + "@" + String.format("%04d", this.arrivalTime);
    }
}
