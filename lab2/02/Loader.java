public class Loader {

    protected final Cruise cruiseServed;
    protected final int id; 

    public Loader(int id) {
        this.id = id;
        this.cruiseServed = null;
    }

    public Loader(int id, Cruise cruiseServed) {
        this.id = id;
        this.cruiseServed = cruiseServed;
    }

    public Loader serve(Cruise cruise) {
        if (cruise == null) {
            return this;
        } else if (!canServe(cruise)) {
            return null;
        } else {
            return new Loader(id, cruise);
        }
    }

    public int getID() {
        return this.id;
    }

    public Cruise getCruiseServed() {
        return this.cruiseServed;
    }

    public boolean canServe(Cruise cruise) {
        return !isServing()
            || cruise.getArrivalTime() >= cruiseServed.getServiceCompletionTime();
    }

    public boolean isServing() {
        return cruiseServed != null;
    }

    @Override
    public String toString() {
        if (isServing()) {
            return String.format("Loader %d serving %s", id, cruiseServed);
        } else {
            return String.format("Loader %d", id);
        }
    } 
}
