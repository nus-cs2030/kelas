public class Cruise {
    private final String identifier;
    private final int arrival;
    private final int loaders;
    private final int serviceTime;

    public Cruise(String identifier, int arrival, int loaders, int serviceTime) {
        this.identifier = identifier;
        this.arrival = arrival;
        this.loaders = loaders;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return String.format(identifier + "@%04d",arrival);
    }

    public int getArrivalTime() {
        int minutes = this.arrival % 100;
        int hours = this.arrival / 100;
        int totalMinutes = hours * 60 + minutes;
        return totalMinutes;
    }

    public int getNumOfLoadersRequired() {
        return this.loaders;
    }

    public int getServiceCompletionTime() {
        int arrivalTime = this.getArrivalTime();
        return arrivalTime + serviceTime;
    }
}

