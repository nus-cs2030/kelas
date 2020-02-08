public class Cruise {
    private final String name;
    private final int arrival;
    private final int loaders;
    private final int service;

    public Cruise(String name, int arrival, int loaders, int service) {
        this.name = name;
        this.arrival = arrival;
        this.loaders = loaders;
        this.service = service;
    }

    public int getArrivalTime() {
	if (this.arrival >= 100) {
		int hours = this.arrival/100;
		int mins = this.arrival%100;
        return (hours*60 + mins);
        }
    else {
        return this.arrival;
        }  
    }

    public int getNumOfLoadersRequired() {
        return this.loaders;
    }

    public int getServiceCompletionTime() {
        return this.getArrivalTime() + this.service;
    }

    @Override
    public String toString() {
        return this.name + "@" + String.format("%04d", this.arrival);
    }
}


    
