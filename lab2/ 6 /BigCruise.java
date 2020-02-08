class BigCruise extends Cruise {
	
	private static int loadersRequired(double length) {
		return (int) Math.ceil(length/40);
	}

	private static int serviceTimeRequired(double numOfPassenger) {
		return (int) Math.ceil(numOfPassenger/50);
	}

	BigCruise(String ID, int arrivalTime, double length, double numOfPassenger) {
		super(ID, arrivalTime, loadersRequired(length), serviceTimeRequired(numOfPassenger));
	}
}
