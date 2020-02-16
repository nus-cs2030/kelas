public class Cruise {

    private String id;
    private int arrivalTime;
    private int loadersRequired;
    private int serviceTime;

    public Cruise(String id, int arrivalTime, int loadersRequired, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.loadersRequired = loadersRequired;
        this.serviceTime = serviceTime;
    }

    public int getArrivalTime() {
        return convertTimeToMinutes(arrivalTime);
    }

    public int getNumOfLoadersRequired() {
        return this.loadersRequired;
    }

    public int getServiceCompletionTime() {
        return serviceTime + getArrivalTime();
    }

    private int convertTimeToMinutes(int time) {
        return ((int) (time / 100) * 60) + (time % 100);
    }

    public boolean isBigCruise() {
        return false;
    }

    @Override 
    public String toString() {
        return String.format("%s@%04d", id, arrivalTime);
    }

}
