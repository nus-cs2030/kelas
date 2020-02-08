class RecycledLoader extends Loader{
    public RecycledLoader(int id) {
        super(id);
    }
    protected RecycledLoader(int id, int[] arr) {
        super(id, arr);
    }
    protected RecycledLoader(int id, int[] arr, Cruise c) {
        super(id, arr, c);
        int start = c.getArrivalTime();
        int end = c.getServiceCompletionTime() + 60;
        if(end > 1440) {
            end = 1440; 
        }
        for(int i = start; i < end; i++) {
            available[i] = 1;
        }
    }
    public boolean canServe(Cruise c) {
        if(c == null) {
            return true;
        } else {
            int start = c.getArrivalTime();
            int end = c.getServiceCompletionTime() + 60;
            if(end > 1440) {
                end = 1440; 
            }
            for(int i = start; i < end; i++) {
                if(available[start] == 1) {
                    return false;
                }
            }
            return true;
        }
    }
    public RecycledLoader serve(Cruise c) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = available[i];
        }
        if(!canServe(c)) {
            return null;
        } else if(c == null) {
            return new RecycledLoader(id, arr);
        } else {
            return new RecycledLoader(id, arr, c);
        }
    }
    public String toString() {
        if(c == null) {
            return "Loader " + id + " (recycled)";
        } else {
            return "Loader " + id + " (recycled)" + " serving " + c.toString();
        }
    }
}