class Loader{ 
    int no;
    Cruise servingCruise;

    public Loader(int no){ 
        this.no = no;
		servingCruise = null;
    }

    private Loader(int no, Cruise cruise){
        this.no = no;
		servingCruise = cruise;
    }

    @Override
    public String toString(){
		if (servingCruise == null){
			return "Loader " + this.no;
		} else { 
			return "Loader " + this.no + " serving " + servingCruise;
		}
    }
    
    public boolean canServe(Cruise cruise){ 
		if (servingCruise == null){
			return true;
		} else if (servingCruise.getServiceCompletionTime() <= cruise.getArrivalTime()){ 
			return true;
		} else { 
			return false;
		}
    }

    public Loader serve(Cruise cruise){ 
		if (canServe(cruise)){
	    	Loader usedLoader = new Loader(no, cruise);
	    	return usedLoader;
		} else {
	    	return null;
		}
    }    
}
