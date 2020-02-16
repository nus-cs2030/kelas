class Loader {
    final int ID;
    Cruise serving;
    boolean available;

	/*
		Indentaion is quite messy here! 

		Please do check for indentation next time before you submit! 
	*/
    Loader(int ID){
        this.ID = ID;
	this.serving = null;
	this.available = true;
    }

    Loader(int ID, Cruise cruise){
	this.ID = ID;
	this.serving = cruise;
	this.available = false;
    }

    Loader serve(Cruise cruise){
	if (cruise == null) {
		return new Loader(this.ID);
	} else if (this.available || this.serving.getServiceCompletionTime() <= cruise.getArrivalTime()){
        	return new Loader(this.ID, cruise);
	} else {
		return null;
	}
    }

    boolean canServe(Cruise cruise){
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
		    return "Loader " + this.ID + " serving " + this.serving;
	    }
    }
}



 
