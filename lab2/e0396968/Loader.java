class Loader {
    protected final int id;
    protected final int availTime;
    protected final Cruise currentServing;

    Loader(int id) {
        this.id = id;
        this.availTime = 0;
        this.currentServing = null;
    }

    Loader(int id, int availTime, Cruise currentServing) {
        this.id = id;
        this.availTime = availTime;
        this.currentServing = currentServing;
    }

    public boolean canServe(Cruise cruise) {
        if (cruise == null) {
            return true;
        } else {
            return cruise.getArrivalTime() >= availTime;
        }
    }

    public Loader serve(Cruise cruise) {
        if (cruise == null) {
            return new Loader(this.id);
        } else if (this.canServe(cruise)) {
            return new Loader(this.id, cruise.getServiceCompletionTime(), cruise);
        } else {
            return null;
        }
    }

    public String toString() {
        if (this.currentServing != null) {
            return "Loader " + this.id + " serving " + this.currentServing;
        } else {
            return "Loader " + this.id;
        }
    }
}
