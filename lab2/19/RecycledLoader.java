public class RecycledLoader extends Loader {
	
	RecycledLoader(int id) {
		super(id);
	}

	@Override
	public boolean canServe(Cruise cruise) {

		if (this.cruise == null || cruise == null) { // not serving any cruise
			return true;

		} else if (this.cruise.getServiceCompletionTime() + 60 <= cruise.getArrivalTime()) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public RecycledLoader serve(Cruise cruise) {
		
		if (canServe(cruise)) {
			RecycledLoader Rloader = new RecycledLoader(this.id);
			Rloader.cruise = cruise;
			return Rloader;

		} else {
			return null;
		}
	} 

	@Override
	public String toString() {

		if (this.cruise == null) {
			return "Loader " + this.id;
		} else {
			return "Loader " + this.id + " (recycled)" + " serving " + cruise;
		}
	}
}


