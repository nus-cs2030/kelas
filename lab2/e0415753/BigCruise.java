class BigCruise extends Cruise {


    public BigCruise(String identifier, int timeArrived, int cruiseLength, int numberOfPassengers){
        super(identifier, timeArrived, ((int)java.lang.Math.ceil((double)cruiseLength/40)), 
                ((int)java.lang.Math.ceil((double)numberOfPassengers/50)));
    }

} 
