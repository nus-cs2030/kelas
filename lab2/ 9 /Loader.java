import java.lang.String;

public class Loader {
    protected final int id;
    
    protected final int serviceCompletionTime;
    
    protected final Cruise cruise;

    public Loader(int id) {
        this.id = id;
        
        this.serviceCompletionTime = 0;
        
        this.cruise = null;
    }

    public Loader(int id, int serviceCompletionTime, Cruise cruise) {
        this.id = id;
        
        this.serviceCompletionTime = serviceCompletionTime;
        
        this.cruise = cruise;
    }
    
    public boolean canServe(Cruise cruise) {
        if (serviceCompletionTime == 0) {
            return true;
        } else if (this.serviceCompletionTime <= cruise.getArrivalTime()) {
            return true;
        } else {
            return false;
        }
    }

    public Loader serve(Cruise cruise) {  
        if (cruise == null) {
            return new Loader(this.id);
        } else if (this.canServe(cruise)) {
            Loader newLoad = new Loader(this.id, cruise.getServiceCompletionTime(), cruise);  
            return newLoad;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.cruise != null) {
            return "Loader " + this.id + " serving " + cruise.toString();
        } else {
            return "Loader " + this.id;
        }
        
    }


}