class SmallCruise extends Cruise {
    private static final int numLoaders = 1;
    private static final int serviceTime = 30;

    SmallCruise(String id, int arrivalTime) {
        super(id, arrivalTime, SmallCruise.numLoaders, SmallCruise.serviceTime);
    }
}
