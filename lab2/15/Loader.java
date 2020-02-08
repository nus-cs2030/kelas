public class Loader {
    private final int loaderId;
    private final Cruise cruise;

    public Loader(int loaderId){
        this.loaderId = loaderId;
        this.cruise = null;
    }

    public Loader(int loaderId, Cruise cruise){
        this.loaderId = loaderId;
        this.cruise = cruise;
    }

    public int getLoaderId() {
        return loaderId;
    }

    public Cruise getCruise() {
        return cruise;
    }

    //return type revisit and modify
    public Loader serve(Cruise cruise){
        if(canServe(cruise)){
            return new Loader(this.loaderId, cruise);
        }else{
            return null;
        }
    }

    public boolean canServe(Cruise cruise){
        if(this.cruise == null || cruise == null || this.cruise.getServiceCompletionTime() <= cruise.getArrivalTime()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        if(this.cruise == null){
            return "Loader " + this.loaderId;
        }else{
            return "Loader " + this.loaderId + " serving " + this.cruise.toString();
        }
    }
}
