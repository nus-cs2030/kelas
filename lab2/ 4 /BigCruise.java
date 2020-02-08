class BigCruise extends Cruise {

    public static int numOfLoaders(double length) {
        return (int) Math.ceil(length / 40);
    }

    public static int serviceTime (double passengers) {
        return (int) Math.ceil(passengers / 50);
    }

    BigCruise (String id, int arrtime, int len, int num) {
        super(id, arrtime, numOfLoaders(len), serviceTime(num));
    }

}