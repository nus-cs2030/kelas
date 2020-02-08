public class BigCruise extends Cruise {

	public BigCruise(String id, int arrival, int length, int passengers) {
		super(id, arrival, (int) Math.ceil( (double) length / (double) 40 ), (int) Math.ceil( (double) passengers / (double) 50));
	}
	
}
