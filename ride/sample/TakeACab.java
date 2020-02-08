public class TakeACab extends Service {
    public TakeACab() {
    }

    @Override
    public int computeFare(Request req) {
        int sum = 200 + req.dist * 33;
        return sum;
    }

    @Override
    public String toString() {
        return "TakeACab";
    }
}

