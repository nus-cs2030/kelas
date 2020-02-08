public class Cruise {
    
    protected final String identifier;
    protected final int timeA;
    protected final int nLoaders;
    protected final int serviceT;

    public Cruise ( String identifier, int timeArrived, int numLoaders, int serviceTime){
        this.identifier = identifier;
        this.timeA = timeArrived;
        this.nLoaders = numLoaders;
        this.serviceT = serviceTime;
    }


    public int getArrivalTime (){
        int result = 0;
        int hours = timeA/100;
        int minutes = timeA%100;
        if (hours == 24){
            if (minutes == 0){
                result = hours * 60 + minutes;
            }
        }else if(hours < 24 && hours >= 0){
            if (minutes >= 0 && minutes <60){
                result = hours * 60 + minutes;
            }
        }
        return result;
    }

    public int getServiceCompletionTime (){
        return getArrivalTime() + serviceT;
    }

    public int getNumOfLoadersRequired (){
        return nLoaders;
    }


    @Override
    public String toString(){
        String output = String.format("%s@%04d", identifier, timeA);
        return output;
    }
}
