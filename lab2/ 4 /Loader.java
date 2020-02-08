class Loader {
    protected final Cruise serving;
    protected final int id;

    public Loader(int id) {
        this.id = id;
        this.serving = null;
    }

    public Loader(int id, Cruise serving) {
        this.id = id;
        this.serving = serving;
    }

    public boolean canServe (Cruise cruise) {
        //originally i had entered the following
        //int timeOfArrival = cruise.getArrivalTime()
        //then I would use timeOfArrival in the else case
        //but that threw me a null pointer exception error
        if (this.serving == null) {
            return true;
        } else {
            return this.serving.getServiceCompletionTime() <= cruise.getArrivalTime();
        }
    }

    public Loader serve (Cruise cruise) {
        if (canServe(cruise)) {
            return new Loader(this.id, cruise);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.serving == null) {
            return "Loader " + this.id;
        } else {
            return "Loader " + this.id + " serving " + serving; 
        }
    }
}