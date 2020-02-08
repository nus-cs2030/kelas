class Loader {

	protected final int id;
	protected Cruise cruise;

	Loader(int id) {

		this.id = id;
		this.cruise = null;
	}
	
	public boolean canServe(Cruise cruise) {

		if (this.cruise == null || cruise == null) { // not serving any cruise
			return true;

		} else { // serving a cruise
			
			if (this.cruise.getServiceCompletionTime() <= cruise.getArrivalTime()) {

				return true;

			} else {           
				return false;
			}
		}
	}

	public Loader serve(Cruise cruise) {

		if (canServe(cruise)) { 
			Loader loader = new Loader(this.id);	
			loader.cruise = cruise;
			return loader;
				
		} else {
			return null;
		}
	}
	
	public String toString() {

		if (cruise == null) {
			return "Loader " + this.id;
		} else {
			return "Loader " + this.id + " serving " + cruise;
		}
	}
}









