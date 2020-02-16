class Cruise{
    final String identifier;
    final int arrival_time;
    final int loaders_needed;
    final int service_time;

    /*
        Access Modifiers should be given for methods! 
        Variable Names are slightly different in Java as Compared to JS / Python! 
        Try this in the future using lowerCamelCase for attributes, such as serviceTime. 
    */
    Cruise(String identifier, int arrival_time, int loaders_needed, int service_time){
        this.identifier = identifier;
        this.arrival_time = arrival_time;
        this.loaders_needed = loaders_needed;
        this.service_time = service_time;
    }
    
    @Override
    public String toString(){
        return this.identifier + "@" + String.format( "%04d",this.arrival_time );
    }

    int getServiceCompletionTime(){
        return (this.arrival_time/100)*60 + this.arrival_time%100 +  this.service_time;
    }

    int getArrivalTime(){
        if(this.arrival_time>=100){
            return (this.arrival_time/100)*60 + this.arrival_time%100; 
        } else {
            return this.arrival_time;
        }
    }

    int getNumOfLoadersRequired(){
        return this.loaders_needed;
    }

}


