class BigCruise extends Cruise{

    BigCruise(String id, int arrivalt, int len_cr, int passen_num){
        super(id, arrivalt,(int)Math.ceil(len_cr/40.0), (int)Math.ceil(passen_num/50.0));

    }
}