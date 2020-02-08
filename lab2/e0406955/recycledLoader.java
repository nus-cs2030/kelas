class recycledLoader extends Loader {
    
    recycledLoader(int ID) {
        super(ID);
    }
    
    recycledLoader(int ID, Cruise cruise) {
        super(ID, cruise);
    }

    @Override
    public boolean canServe(Cruise cruise) {
        return this.servingCruise == null || cruise == null || this.servingCruise.getServiceCompletionTime() + 60 <= cruise.getArrivalTime();
    }

    @Override
    public recycledLoader serve(Cruise cruise) {
        if (canServe(cruise)) {
            return new recycledLoader(this.loaderID, cruise);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.servingCruise == null) {
            return "Loader " + this.loaderID + " (recycled)";
        } else {
            return "Loader " + this.loaderID + " (recycled) serving " + this.servingCruise;
        }
    }
}
