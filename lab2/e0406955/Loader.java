class Loader {
	protected final int loaderID;
	protected final Cruise servingCruise;

	Loader(int loaderID) {
		this.loaderID = loaderID;
		this.servingCruise = null;
	}

	Loader(int loaderID, Cruise cruise) {
		this.loaderID = loaderID;
		this.servingCruise = cruise;
	}

	public boolean canServe(Cruise cruise) {
		return cruise == null || this.servingCruise == null || this.servingCruise.getServiceCompletionTime() <= cruise.getArrivalTime();
	}

	public Loader serve(Cruise cruise) {
		if (this.canServe(cruise)) {
			return new Loader(this.loaderID, cruise);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		if (servingCruise == null) {
			return "Loader " + loaderID;
		} else {
			return "Loader " + loaderID + " serving " + servingCruise;
		}
	}
}
