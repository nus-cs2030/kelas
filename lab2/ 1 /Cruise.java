public class Cruise {
    private final String id;
    private final int tArrival;
    private final int noLoaders;
    private final int tService;

    public Cruise(String a, int b, int c, int d) {
        id = a;
        tArrival = b;
        noLoaders = c;
        tService = d;
    }

    public int getNumOfLoadersRequired() {
        return noLoaders;
    }

    public int getArrivalTime() {
        int h = tArrival / 100;
        int m = tArrival - h * 100;
        return h * 60 + m;
    }

    public int getServiceCompletionTime() {
        return getArrivalTime() + tService;
    }

    @Override
    public String toString() {
        return id + "@" + String.format("%04d", tArrival);
    }
}
