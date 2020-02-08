class Cruise {
    protected final String identifier;
    public final int timeOfArrival;
    protected final int numOfLoaders;
    protected final int serviceTime;

    protected Cruise(String id, int arrtime, int num, int servtime) {
        this.identifier = id;
        this.timeOfArrival = arrtime;
        this.numOfLoaders = num;
        this.serviceTime = servtime;
    }    

    public int convertTime(int time) {
        int hour = time / 100;
        int min = time % 100;
        return hour * 60 + min;
    }    
    
    public int getServiceCompletionTime() {
        return convertTime(this.timeOfArrival) + this.serviceTime;
    }

    public int getArrivalTime() {
        return convertTime(this.timeOfArrival);
    }

    public int getNumOfLoadersRequired() {
        return this.numOfLoaders;
    }   

    @Override
    public String toString() {
        return this.identifier + "@" + String.format("%04d",this.timeOfArrival);
    }
}    
