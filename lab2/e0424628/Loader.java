public class Loader {
    private final int id;
    Cruise cruise;

    public Loader(int id) {
        this.id = id;
        this.cruise = null;
    }

    public Loader(int id, Cruise cruise) {
        this.id = id;
        this.cruise = cruise;
    }

    public Loader serve(Cruise cruise) {
        if (this.canServe(cruise)) {
            return new Loader(this.id, cruise);
        } else {
            return null;
        }
    }

    public boolean canServe(Cruise cruise) {
        if (this.cruise == null) {
            return true;
        } else {
            return this.cruise.getServiceCompletionTime() <= cruise.getArrivalTime();
        }
    }

    @Override
    public String toString() {
        if (cruise != null) {
            return "Loader " + id + " serving " + this.cruise;
        } else {
            return "Loader " + id;
        }
    }
}
