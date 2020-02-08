public class RecycledLoader extends Loader {

    public RecycledLoader(int loaderId) {
        super(loaderId);
    }

    public RecycledLoader(int loaderId, Cruise cruise) {
        super(loaderId, cruise);
    }

    @Override
    public RecycledLoader serve(Cruise cruise){
        if(canServe(cruise)){
            return new RecycledLoader(this.getLoaderId(), cruise);
        }else{
            return null;
        }
    }

    @Override
    public boolean canServe(Cruise cruise){
        if(this.getCruise() == null || cruise == null || (this.getCruise().getServiceCompletionTime()+60) <= cruise.getArrivalTime()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        if(this.getCruise() == null){
            return "Loader " + this.getLoaderId() + " (recycled)";
        }else{
            return "Loader " + this.getLoaderId() + " (recycled) serving " + this.getCruise().toString();
        }
    }
}