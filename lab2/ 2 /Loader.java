class Loader {
    final protected int id;
    final protected int size = 1440;
    protected int[] available = new int[size];
    protected Cruise c = null;
    public Loader(int id) {
        this.id = id;
    }
    protected Loader(int id, int[] arr) {
        this.id = id;
        available = arr;
    }
    protected Loader(int id, int[] arr, Cruise c) {
        this.id = id;
        this.c = c;
        available = arr;
        int start = c.getArrivalTime();
        int end = c.getServiceCompletionTime();
        for(int i = start; i < end; i++) {
            available[i] = 1;
        }
    }
    public boolean canServe(Cruise c) {
        if(c == null) {
            return true;
        } else {
            int start = c.getArrivalTime();
            int end = c.getServiceCompletionTime();
            for(int i = start; i < end; i++) {
                if(available[start] == 1) {
                    return false;
                }
            }
            return true;
        }
    }
    public Loader serve(Cruise c) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = available[i];
        }
        if(!canServe(c)) {
            return null;
        } else if(c == null) {
            return new Loader(id, arr);
        } else {
            return new Loader(id, arr, c);
        }
    }
    public String toString() {
        if(c == null) {
            return "Loader " + id;
        } else {
            return "Loader " + id + " serving " + c.toString();
        }
    }
}