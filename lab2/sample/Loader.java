class Loader {
    protected final int id;
    protected final Cruise cruise;
    protected final int doneTime;

    public Loader(int id) {
        this(id, null, 0);
    }

    protected Loader(int id, Cruise c, int doneTime) {
        this.id = id;
        this.cruise = c;
        this.doneTime = doneTime;
    }

    public boolean canServe(Cruise c) {
        if (c != null) {
            return (c.getArrivalTime() >= this.doneTime);
        } else {
            return true;
        }
    }

    public Loader update(Cruise c, int doneTime) {
        return new Loader(this.id, c, doneTime);
    }

    public Loader serve(Cruise c) {
        if (c == null) {
            return this;
        }
        if (this.canServe(c)) {
            int doneTime = c.getServiceCompletionTime();
            return update(c, doneTime);
        } else {
            return null;
        }
    }

    public String toString() {
        if (this.cruise == null) {
            return "Loader " + id;
        } else {
            return "Loader " + id + " serving " + cruise;
        }
    }
}
