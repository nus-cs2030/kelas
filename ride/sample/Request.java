public class Request {
    public int dist;
    public int num;
    public int time;
    public Request(int dist, int num, int time) {
        this.dist = dist;
        this.num = num;
        this.time = time;
    }
    @Override
        public String toString() {
            return this.dist + "km for " + this.num + "pax @ " + this.time + "hrs";
        }
}

