import java.util.ArrayList;

class Loader {
    protected int id;
    protected int nextAvailTime;
    protected ArrayList<Cruise> cruises;

    public Loader(int id) {
        this.id = id;
        this.nextAvailTime = 0;
        this.cruises = new ArrayList<Cruise>();
    }

    public boolean canServe(Cruise cruise) {
        if (cruise == null) {
            return true;
        }
        return nextAvailTime <= cruise.getArrivalTime();
    }

    public Loader serve(Cruise cruise) {
        if (cruise == null) {
            return this;
        }
        if (this.canServe(cruise)) {
            Loader newLoader = new Loader(id);
            newLoader.cruises = new ArrayList<Cruise>(cruises);
            newLoader.cruises.add(cruise);
            newLoader.nextAvailTime = cruise.getServiceCompletionTime();
            return newLoader;
        } else {
            return null;
        }

    }

    public int getNextAvailTime() {
        return nextAvailTime;
    }

    @Override
    public String toString() {
        if (!cruises.isEmpty()) {
            return "Loader " + id + " serving " + cruises.get(cruises.size() - 1); 
        } else {
            return "Loader " + id;
        }
    }
}
