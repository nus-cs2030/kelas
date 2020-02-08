class BigCruise extends Cruise{
	final private double length;
	final private double passengers;
	//Requires 1loader/40m
	//int loaders = (int)
	//Serves 50passengers/min
	//int service = (int) ;

	public BigCruise(String ID, int arrival, double length, double passengers){
		super(ID, arrival,  (int) Math.ceil(length/40), (int) Math.ceil(passengers/50));
		this.length = length;
		this.passengers = passengers;
	}
}

