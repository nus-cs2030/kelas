public class BigCruise extends Cruise {

    private final int length;
    private final int numOfPassengers;
    public BigCruise(String identity, int arrivalTime, int length, int numOfPassengers) {
        super(identity, arrivalTime, (int) Math.ceil((double)length / (double)40), (int) Math.ceil((double)numOfPassengers / (double)50));
        //System.out.println(this.getServiceCompletionTime() + " : " + this.getNumOfLoadersRequired());
        this.length = length;
        this.numOfPassengers = numOfPassengers;
    }

}
