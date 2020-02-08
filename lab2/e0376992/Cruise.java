class Cruise {
    final String id;
    final int arrival;
    final int loaders;
    final int serviceTime;
    public Cruise(String id, int arrival, int loaders, int serviceTime) {
        this.id = id;
        this.arrival = arrival;
        this.loaders = loaders;
        this.serviceTime = serviceTime;
    }
    public int getArrivalTime() {
        int m = arrival % 100;
        int h = (arrival - m) / 100;
        return h * 60 + m;
    }
    public int getServiceCompletionTime() {
        int time = getArrivalTime();
        return time + serviceTime;
    }
    public int getNumOfLoadersRequired() {
        return loaders;
    }
    public String toString() {
        return this.id + "@" + String.format("%04d", arrival);
    }
}