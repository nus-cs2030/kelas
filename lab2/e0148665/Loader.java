public class Loader {
    protected final int id;
    protected final Cruise sCruise;

    public Loader(int a) {
        id = a;
        sCruise = null;
    }

    public Loader(int a, Cruise c) {
        id = a;
        sCruise = c;
    }

    public Loader serve(Cruise c) {
        if(canServe(c)) {
            return new Loader(id, c);
        } else {
            return null;
        }
    }

    public boolean canServe(Cruise c) {
        if (sCruise == null) {
            return true;
        } else {
            return sCruise.getServiceCompletionTime() <=
                c.getArrivalTime();
        }
    }

    @Override
    public String toString() {
        if (sCruise != null) {
            return "Loader " + id + " serving " + sCruise;
        } else {
            return "Loader " + id;
        }
    }
}
