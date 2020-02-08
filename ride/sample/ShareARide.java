public class ShareARide extends Service {
    public ShareARide() {
    }

    public int computeFare(Request req) {
        int sum = 0;
        if (req.time >= 600 && req.time <= 900) {
            sum += 500;
        }
        sum = sum + 50 * req.dist;
        sum = sum / req.num;
        return sum;
    }

    @Override
    public String toString() {
        return "ShareARide";
    }
}

