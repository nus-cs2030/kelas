public class rLoader extends Loader {


	public rLoader(int id) {
		super(id);
	}
	
	public rLoader(int id, Cruise c) {
		super(id, c);
	}

	@Override
	public boolean canServe(Cruise c) {
		if (this.cruise == null) {
			return true;
		} else {
			return c.getArrivalTime() >= this.cruise.getServiceCompletionTime() + 60;
		}
	}

	@Override
	public Loader serve(Cruise c) {
		if ( canServe(c) == true ) {
			return new rLoader(this.id, c);
		} else {
			return null;
		}
	}


	@Override
	public String toString() {
		return "Loader " + this.id + " (recycled) serving " + this.cruise;
	}
	
}
