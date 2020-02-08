import java.lang.String;

public class RecycledLoader extends Loader {

    public RecycledLoader(int id, int serviceCompletionTime, Cruise cruise) {
        super(id, serviceCompletionTime, cruise);
    }

    @Override
    public Loader serve(Cruise cruise) {  
        if (cruise == null) {
            return new Loader(this.id);
        } else if (this.canServe(cruise) && (this.id % 3) == 0) {
            Loader newLoad = new RecycledLoader(this.id, cruise.getServiceCompletionTime() + 60, cruise);  
            return newLoad;
        } else if (this.canServe(cruise)) {
            Loader newLoad = new Loader(this.id, cruise.getServiceCompletionTime(), cruise);
            return newLoad;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.cruise != null && (this.id % 3) == 0) {
            return "Loader " + this.id + " (recycled)" + " serving " + cruise.toString();
        } else if (this.cruise != null) {
            return "Loader " + this.id + " serving" + cruise.toString();
        } else {
            return "Loader " + this.id;
        }
    }
}