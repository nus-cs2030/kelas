class Cruise{
    private final String identi;
    private final int arrivalt;
    private final int servet;
    private final int loaders;

    Cruise(String identi, int arrivalt, int loaders, int servet){
        this.identi = identi;
        this.arrivalt = arrivalt;
        this.loaders = loaders;
        this.servet = servet;
    }

    int getArrivalTime(){
        int min = this.arrivalt % 100;
        int hr = (this.arrivalt - min)/100;
        return hr * 60 + min;
    }

    int getNumOfLoadersRequired(){
        return this.loaders;

    }

    int getServiceCompletionTime(){

        return this.getArrivalTime() + this.servet;
    }

    @Override
    public String toString(){
        return identi + "@" + String.format("%04d", arrivalt);
    }

}

