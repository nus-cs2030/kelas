public class Cruise {
    private final String id;
    private final int arrival;
    private final int loaders;
    private final int servicet;

    public Cruise(String id, int arrival, int loaders, int servicet) {
        this.id = id;
        this.arrival = arrival;
        this.loaders = loaders;
        this.servicet = servicet;
    }

    public int getServiceCompletionTime() {
        return this.arrival / 100 * 60 + this.arrival % 100 + this.servicet;
    }

    public int getArrivalTime() {
        return this.arrival / 100 * 60 + this.arrival % 100;
    }

    public int getNumOfLoadersRequired() {
        return this.loaders;
    }

    @Override
    public String toString() {
        return this.id + "@" + String.format("%04d", this.arrival);
    }


}


