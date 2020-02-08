class Loader{
    final int ID;
    final Cruise cr;

    Loader(int ID){
        this.ID = ID;
        this.cr = null;
    }

    Loader(int ID, Cruise cr){
        this.ID = ID;
        this.cr = cr;
    }



    boolean canServe(Cruise cruise){
         return this.cr == null || cruise == null || cruise.getArrivalTime() >= this.cr.getServiceCompletionTime();

    }

    Loader serve(Cruise cruise){
        if(canServe(cruise))
            return new Loader(ID, cruise);
        else
            return null;
    }

    @Override
    public String toString(){
        if(this.cr == null){
            return "Loader " + this.ID;
        } else {
            return "Loader " + this.ID +" serving "+ this.cr;
   
        }
    }
}
