class RecycledLoader extends Loader {
    public RecycledLoader(int id) {
        super(id);
    }

    protected RecycledLoader(int id, Cruise c) {
        super(id, c);
    }

    private boolean availableFor(Cruise c) {
        assert hasCruise();
        int currCompletionTime = cruise.getServiceCompletionTime();
        int readyTime = currCompletionTime + 60;
        return c.getArrivalTime() >= readyTime;
    }

    @Override
    public boolean canServe(Cruise c) {
        return !super.hasCruise() || availableFor(c);
    }

    @Override
    public Loader serve(Cruise c) {
        if (!canServe(c)) {
            return null;
        }
        return new RecycledLoader(this.id, c);
    }

    @Override
    public String toString() {
        if (cruise != null) {
            return String.format("Loader %d (recycled) serving %s", id, cruise);
        } else {
            return String.format("Loader %d (recycled)", id);
        }
    }
}
