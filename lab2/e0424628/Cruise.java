public class Cruise {
    private final String identity;
    private final int arrivalTime;
    private final int loaders;
    private final int serviceTime;

    public Cruise(String identity, int arrivalTime, int loaders, int serviceTime) {
        this.identity = identity;
        this.arrivalTime = arrivalTime;
        this.loaders = loaders;
        this.serviceTime = serviceTime;
    }

    public String getIdentity() {
        return this.identity;
    }

    //remember to format with 4 white spaces instead of tabs - also refer to cs2030 syntax document
    public int getArrivalTime() {
        return (arrivalTime / 100) * 60 + (arrivalTime % 100);
    }

    public int getServiceCompletionTime() {
        return getArrivalTime() + this.serviceTime;
    }

    public int getNumOfLoadersRequired() {
        return loaders;
    }

    @Override
    public String toString() {
        return identity + "@" + String.format("%04d", arrivalTime);
    }

}
