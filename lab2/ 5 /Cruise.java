class Cruise {
    private String id;
    private int arrivalTime;
    private int loadersReq;
    private int serviceTime;

    public Cruise(String id, int arrivalTime, int loadersReq, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.loadersReq = loadersReq;
        this.serviceTime = serviceTime;
    }

    public int getServiceCompletionTime() {
        return arrivalTime / 100 * 60 + arrivalTime % 100 + serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime / 100 * 60 + arrivalTime % 100;
    }

    public int getNumOfLoadersRequired() {
        return loadersReq;
    }

    @Override
    public String toString() {
        return String.format(id + "@%04d", arrivalTime);
    }
}


