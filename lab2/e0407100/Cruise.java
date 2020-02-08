class Cruise{
	final protected String name;
	final protected int arrival;
	final protected int loaders;
	final protected int service;

	public Cruise(String name, int arrival, int loaders, int service){
		this.name = name;
		this.arrival = arrival;
		this.loaders = loaders;
		this.service = service;
	}


	public int getServiceCompletionTime (){
		int total = (getArrivalTime()+this.service)%2400;
		return total;
	}

	public int getArrivalTime(){
		int min = this.arrival%100;
		int hour = this.arrival/100;
		return hour*60+min;
	}

	public int getNumOfLoadersRequired(){
		return this.loaders;
	}

	@Override
	public String toString(){
		return this.name + "@" +  String.format("%04d",this.arrival);
	}
}

