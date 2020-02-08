class Cruise {
  private final String id;
  private final int arrivalTime;
  private final int numOfLoader;
  private final int serviceTime;
  
  protected Cruise(String id, int arrivalTime, int numOfLoader, int serviceTime) {
    this.id = id;
    this.arrivalTime = arrivalTime;
    this.numOfLoader = numOfLoader;
    this.serviceTime = serviceTime;
  }

  public int getArrivalTime() {
    return 60 * (this.arrivalTime / 100) + (this.arrivalTime % 100);
  }

  public int getNumOfLoadersRequired() {
    return numOfLoader;
  }

  public int getServiceTime() {
    return serviceTime;
  }
  
  public int getServiceCompletionTime() {
    return getArrivalTime() + getServiceTime(); 
  }

  public String toString() {
    return id + "@" + String.format("%04d", arrivalTime);
  }
}
