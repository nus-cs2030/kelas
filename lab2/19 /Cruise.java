public class Cruise {

	protected final String id;
	protected final int arrival;
	protected final int loaders;
	protected final int service;

	protected Cruise(String id, int arrival, int loaders, int service) {

		this.id = id;
		this.arrival = arrival;
		this.loaders = loaders;
		this.service = service;
	
	}

	public int getServiceCompletionTime() {

		return this.service + getArrivalTime();
	}


	public int getArrivalTime() {

		int hours = this.arrival / 100;
		int mins = this.arrival % 100;
		return hours * 60 + mins;
	}


	public int getNumOfLoadersRequired() {

		return this.loaders;
	}

	@Override
	public String toString() {
		return this.id + "@" + String.format("%04d", this.arrival);
	}

}



