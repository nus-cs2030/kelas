public class Loader {
    protected final int id;
    protected final Cruise cruise;


    public Loader(int id) {
        this.id = id;
	this.cruise = null;
    }

    public Loader(int id, Cruise c){
	    this.id = id;
	    this.cruise = c;

    }

    public boolean canServe(Cruise c) {
	    if (this.cruise == null) {
		    return true;
	    } else {
		    return c.getArrivalTime() >= this.cruise.getServiceCompletionTime();
	    }
    }


    public Loader serve(Cruise c) {
        if ( canServe(c) == true ) {
		return new Loader(this.id, c);
	} else {
		return null; }
    }

    @Override
    public String toString() {
	    if (this.cruise == null) {
		    return "Loader " + this.id;
	    } else {
		    return "Loader " + this.id + " serving " + this.cruise;
	    }
    }
}
