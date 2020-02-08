class Loader{
    private final int Id;
    private final Cruise c;

    public Loader (int Id, Cruise c){
        this.Id = Id;
        this.c = c;
    }   

    public Loader (int Id){
        this.Id = Id;
        this.c = null;
    }


    public Loader serve(Cruise d){
        if (this.canServe(d)){
            return new Loader (Id, d);
        }else{
            return null;
        }
    }


    public boolean canServe(Cruise e){
        if (c == null){
            return true;
        }else if (c.getServiceCompletionTime() <=  e.getArrivalTime()){
            return true;
        }else{
            return false;
        }

    }
    public String toString(){
        if (c == null){
            return String.format("Loader %s", Id);
        }else{
            return String.format("Loader %s serving %s", Id, c);
        }
    }
}
