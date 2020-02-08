class Loader6 extends Loader{
    Loader6(int ID){
        super(ID);
    }
    Loader6(int ID, Cruise cr){
        super(ID, cr);
    }


    @Override
    boolean canServe(Cruise cruise){
        return super.cr == null || cruise == null || cruise.getArrivalTime() >= super.cr.getServiceCompletionTime() + 60;

    }
    Loader serve(Cruise cruise){
        if(canServe(cruise))
            return new Loader6(ID, cruise);
        else
            return null;
    }


    @Override
    public String toString(){
        if(super.cr == null){
            return "Loader " + super.ID + "(recycled) ";
        } else {
            return "Loader " + super.ID +" (recycled) serving "+ super.cr;

        }
    }
}