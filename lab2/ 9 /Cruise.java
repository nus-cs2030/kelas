import java.lang.String;

public class Cruise {
    private final String identity;
    private final int timeOfArrival;
    private final int loadersReq;
    private final int servTime;

    Cruise(String identity, int timeOfArrival, int loadersReq, int servTime) {
        this.identity = identity;
        this.timeOfArrival = timeOfArrival;
        this.loadersReq = loadersReq;
        this.servTime = servTime;
    }

    public int getServiceCompletionTime() {
        return this.getArrivalTime() + this.servTime;
    }

    public int getArrivalTime() {
        int hours = (this.timeOfArrival / 100) * 60;
        int minutes = this.timeOfArrival % 100;

        return hours + minutes;
    }

    public int getNumOfLoadersRequired() {
        return loadersReq;
    }

    @Override
    public String toString() {
        return this.identity + "@" + String.format("%04d", this.timeOfArrival);
    }


}
