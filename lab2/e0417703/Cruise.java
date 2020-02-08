class Cruise {
    protected final String id;
    protected final int arrivalTime;
    protected final int numLoaders;
    protected final int serveTime;
    
    public Cruise(String id, int arrivalTime, int numLoaders, int serveTime) {
        this.id = id;

        int hours = arrivalTime / 100;
        int minutes = arrivalTime % 100;

        this.arrivalTime = (hours * 60) + minutes;
        this.numLoaders = numLoaders;
        this.serveTime = serveTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getNumOfLoadersRequired() {
        return this.numLoaders;
    }

    public int getServiceCompletionTime() {
        return this.arrivalTime + this.serveTime;
    }

    @Override
    public String toString() {
        int hours = (this.arrivalTime / 60) * 100;
        int minutes = this.arrivalTime % 60;
        return String.format("%s@%04d", this.id, hours + minutes);
    }
}
