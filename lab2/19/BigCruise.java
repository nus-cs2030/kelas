public class BigCruise extends Cruise {

	BigCruise(String id, int arrival, double length, double passengers) {

		super(id, arrival, (int) (Math.ceil(length/40)), (int) (Math.ceil(passengers/50)));
	}
}

