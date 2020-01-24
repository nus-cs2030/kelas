public class JustRide extends Service {
    public JustRide() {
    }
    @Override
        public int computeFare(Request req) {
            int sum = 0;
            if (600<=req.time && req.time<=900) {
                sum += 500;
            }
            sum = sum + 22*req.dist;
            return sum;
        }
    @Override
        public String toString() {
            return "JustRide";
        }
}

