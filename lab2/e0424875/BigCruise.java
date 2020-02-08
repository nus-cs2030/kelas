class BigCruise extends Cruise {

	BigCruise(String identifier, int timeOfArrival, int length, int passengers) {
		super(identifier, timeOfArrival, (int)Math.ceil((double)length/40), (int)Math.ceil((double)passengers/50));
        }
}
