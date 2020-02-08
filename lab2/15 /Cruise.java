public class Cruise {
    private final String identity;
    private final int arrivalTime;
    private final int numOfLoadersRequired;
    private final int serviceTime;

    public Cruise(String identity, int arrivalTime, int numOfLoadersRequired, int serviceTime) {
        this.identity = identity;
        this.arrivalTime = arrivalTime;
        this.numOfLoadersRequired = numOfLoadersRequired;
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        int arrivalHrs = arrivalTime / 100;
        int arrivalMins = arrivalTime % 100;
        return arrivalHrs * 60 + arrivalMins;
    }

    public String getIdentity() {
        return identity;
    }

    public int getNumOfLoadersRequired() {
        return numOfLoadersRequired;
    }

    public int getServiceCompletionTime() {
        int arrivalHrs = arrivalTime / 100;
        int arrivalMins = arrivalTime % 100;
        int serviceCompletionTime = arrivalHrs * 60 + arrivalMins + serviceTime;
        return serviceCompletionTime;
    }

    @Override
    public String toString(){
        return this.identity + "@" + String.format("%04d", this.arrivalTime);
    }
}
