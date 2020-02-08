public class Loader {
    final int id;
    final int time;
    final Cruise cruise;

    public Loader(int id) {
        this.id = id;
        this.time = 0;
        this.cruise = null;
    }

    protected Loader(int id, int time, Cruise cruise) {
        this.time = time;
        this.id = id;
        this.cruise = cruise;
    }

    public boolean canServe(Cruise cruise) {
        if (cruise == null) {
            return true;
        } else {
            return time <= cruise.getArrivalTime();
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

    @Override
    public String toString() {
        if (this.cruise == null) {
            return "Loader " + this.id;
        } else {
            return "Loader " + this.id + " serving " + this.cruise;
        }
    }
}

