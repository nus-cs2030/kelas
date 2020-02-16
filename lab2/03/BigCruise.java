class BigCruise extends Cruise{
        BigCruise(String ID, int arrival, int loaderNumber, int serviceTime){
                super(ID, arrival, (int)(Math.ceil(loaderNumber / 40.0)),
                    (int)(Math.ceil(serviceTime/50.0)));
        }
}
