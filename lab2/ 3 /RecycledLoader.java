class RecycledLoader extends Loader {

    RecycledLoader(int id) {
        super(id);
    }

    RecycledLoader(int id, int availTime, Cruise currentServing) {
        super(id, availTime, currentServing);
    }

    public Loader serve(Cruise cruise) {
        if (cruise == null) {
            return new RecycledLoader(super.id);
        } else if (super.canServe(cruise)) {
            return new RecycledLoader(super.id, cruise.getServiceCompletionTime() + 60, cruise);
        } else {
            return null;
        }
    }

    public String toString() {
        if (super.currentServing != null) {
            return "Loader " + super.id + " (recycled) serving " + super.currentServing;
        } else {
            return "Loader " + super.id + " (recycled)";
        }
    }

}
