public class RecycledLoader extends Loader {

    private static final int DELAY_TIME = 60;

    public RecycledLoader(int id) {
        super(id);
    }

    public RecycledLoader(int id, Cruise loadingCruise) {
        super(id, loadingCruise);
    }

    @Override
    public boolean canServe(Cruise cruise) {
        if (!isServing()) {
            return true;
        }

        int loadedCruiseCompletionTime = getCruiseServed().getServiceCompletionTime();
        int incomingCruiseArrivalTime = cruise.getArrivalTime();

        return (loadedCruiseCompletionTime + DELAY_TIME) <= incomingCruiseArrivalTime;
    }

    @Override
    public Loader serve(Cruise cruise) {
        if (canServe(cruise)) {
            return new RecycledLoader(id, cruise); 
        } else {
            return null;
        }
    }

    @Override 
    public String toString() {
        if (isServing()) {
            return String.format("Loader %d (recycled) serving %s", getID(), getCruiseServed().toString());
        } else {
            return String.format("Loader %d (recycled)", getID());
        }
    }
}
