/*
	Good practice to declare your classes public!
*/
class BigCruise extends Cruise {

	/*
		Add whitespace between operators to make your code cleaner!
	*/
	BigCruise(String ID, int time, double length, double passengers){
		super(ID, time,(int)Math.ceil(length/40),(int)Math.ceil(passengers/50));
	}

	
}
