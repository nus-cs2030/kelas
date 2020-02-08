class Loader{
	final int ID;
	final Cruise serving;

	Loader(int ID){
		this.ID = ID;
		this.serving = null;
	}
	Loader(int ID, Cruise serving){
		this.ID = ID;
		this.serving = serving;
	}

	public Loader serve(Cruise cruise){
		if(canServe(cruise)){
			Loader output = new Loader(this.ID, cruise);
			return output;
		}else{
			return null;
		}
	}

	public boolean canServe(Cruise cruise){
		if(serving == null){
			return true;
		}else{
			return this.serving.getServiceCompletionTime()<=cruise.getArrivalTime();
		}

	}

	@Override
	public String toString(){
		if(serving == null){
			return  "Loader " + this.ID;
		}else{
			return "Loader " + this.ID + " serving " + serving;
		}
	}
}
