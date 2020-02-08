class RecycledLoader extends Loader{

    RecycledLoader(int id) {
        super(id);
    }

    RecycledLoader(int id, Cruise serving) {
        super(id, serving);
    }
    
    @Override
    public Loader serve (Cruise cruise) {
        if (canServe(cruise)) {
            return new RecycledLoader(this.id, cruise);
        } else {
            return null;
        }
    }

    @Override
    public boolean canServe (Cruise cruise) {
        if (this.serving == null) {
            return true;
        } else {
            return this.serving.getServiceCompletionTime() + 60 <= cruise.getArrivalTime();
        }
    }

    @Override
    public String toString() {
        if (this.serving == null) {
            return "Loader " + this.id;
        } else {
            return "Loader " + this.id + " (recycled) serving " + serving; 
        }
    }
}