class Loader6 {
    final int ID;
    Cruise serving;
    boolean available;

    Loader6(int ID){
        this.ID = ID;
	this.serving = null;
	this.available = true;
    }

    Loader6(int ID, Cruise cruise){
	this.ID = ID;
	this.serving = cruise;
	this.available = false;
    }

    Loader6 serve6(Cruise cruise){
	if (cruise == null) {
		return new Loader6(this.ID);
	} else if (this.ID%3==0 && this.available || this.ID%3==0 && this.serving.getServiceCompletionTime() <= cruise.getArrivalTime()){
		return new Loader6(this.ID, new Cruise(cruise.identifier,cruise.arrival_time,cruise.loaders_needed,cruise.service_time+60));
	} else if (this.available || this.serving.getServiceCompletionTime() <= cruise.getArrivalTime()){
        	return new Loader6(this.ID, cruise);
	} else {
		return null;
	}
    }

    boolean canServe6(Cruise cruise){
        if (cruise == null || this.available) {
            return true;
	} else if (this.serving.getServiceCompletionTime() > cruise.getArrivalTime()){
            return false;
        } else {
		return true;
	}
    }

    @Override
    public String toString(){
	    if (this.available) {
		    return "Loader " + this.ID;
	    } else {
		   if (this.ID%3==0){
			  return "Loader " + this.ID + " (recycled) serving " + this.serving;
		   } else { 
		    return "Loader " + this.ID + " serving " + this.serving;
		   }
	    }
    }
}


