import java.lang.*;

class Cruise{
    String identifier;
    int timeOfArrival;
    int loaders;
    int serviceTime;

    @Override
    public String toString(){ 
        return this.identifier + "@" + String.format("%04d", this.timeOfArrival);
    }

    Cruise(String identifier, int timeOfArrival, int loaders, int serviceTime){
        this.identifier = identifier;
        this.timeOfArrival = timeOfArrival;
        this.loaders = loaders;
        this.serviceTime = serviceTime;
    }

    int getNumOfLoadersRequired(){
        return this.loaders;
    }

    int getArrivalTime(){
        return this.timeOfArrival % 100 + (int)(Math.floor(this.timeOfArrival / 100) * 60);
    }

    int getServiceCompletionTime(){
        if (this.timeOfArrival % 100 + (int)(Math.floor(this.timeOfArrival / 100) * 60 + this.serviceTime) > 2400){
            return this.timeOfArrival % 100 + (int)(Math.floor(this.timeOfArrival / 100) * 60 + this.serviceTime) - 2400; 
        } else {
            return this.timeOfArrival % 100 + (int)(Math.floor(this.timeOfArrival/100) * 60 + this.serviceTime);
        }
    }
}
