class Loader {
    protected final int id;
    protected final Cruise cruise;

    public Loader(int id) {
        this(id, null);
    }

    protected Loader(int id, Cruise c) {
        this.id = id;
        this.cruise = c;
    }

    public boolean canServe(Cruise c) {
        return !hasCruise() || isAvailableFor(c);
    }

    protected boolean hasCruise() {
        return this.cruise != null;
    }

    private boolean isAvailableFor(Cruise c) {
        assert hasCruise();
        int currCompletionTime = cruise.getServiceCompletionTime();
        return c.getArrivalTime() >= currCompletionTime;
    }

    public Loader serve(Cruise c) {
        if (!canServe(c)) {
            return null;
        }
        return new Loader(this.id, c);
    }

    @Override
    public String toString() {
        if (cruise != null) {
            return String.format("Loader %d serving %s", id, cruise);
        } else {
            return String.format("Loader %d", id);
        }
    }
}
