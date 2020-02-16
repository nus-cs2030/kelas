public class Cruise{
    private final String ID;
    private final int arrival;
    private final int loaderNo;
    private final int serviceTime;

    public String getID(){
        return this.ID;
    }

    Cruise(String ID, int arrival, int loaderNo, int serviceTime){
        this.ID = ID;
        this.arrival = arrival;
        this.loaderNo = loaderNo;
        this.serviceTime = serviceTime;
     }

    public int getTime(){
            return arrival;
    }

    public int getServiceTime(){
            return serviceTime;
    }
    public int getArrivalTime(){
        int arrivalTime1 = (int)(Math.floor(this.arrival / 100) * 60); 
        int arrivalTime2 = (int)(this.arrival % 100);
        return arrivalTime1 + arrivalTime2;
    }

    public int getServiceCompletionTime(){
        int minutes = this.getArrivalTime() + this.serviceTime;
        return minutes;
     }
    
    public int getNumOfLoadersRequired(){
        return this.loaderNo;
    }

    public String toString(){
         String formatted = String.format("%04d", arrival);
         return ID + "@" + formatted;
     }
}
