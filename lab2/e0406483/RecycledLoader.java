import java.util.ArrayList;

class RecycledLoader extends Loader {
    public RecycledLoader(int id) {
        super(id);
    }

    @Override
    public RecycledLoader serve(Cruise cruise) {
        if (cruise == null) {
            return this;
        }
        if (this.canServe(cruise)) {
            RecycledLoader newLoader = new RecycledLoader(id);
            newLoader.cruises = new ArrayList<Cruise>(cruises);
            newLoader.cruises.add(cruise);
            newLoader.nextAvailTime = cruise.getServiceCompletionTime();
            newLoader.nextAvailTime += 60;
            return newLoader;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (!cruises.isEmpty()) {
            return "Loader " + id + " (recycled) serving " + cruises.get(cruises.size()     - 1);
        } else {
            return "Loader " + id;
        }
    }
}
