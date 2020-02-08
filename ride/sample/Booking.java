public class Booking implements Comparable<Booking> {
    public int price;
    public Driver driver;
    public Service serve;
    public Request req;
    public int wait;

    public Booking(Driver driver, Service serve, Request req) {
        this.driver = driver;
        this.serve = serve;
        this.req = req;
        this.price = (serve.computeFare(req));
    }

    public int compareTo(Booking b) {
        if (b.price == this.price) {
            return this.driver.getWait() - b.driver.getWait();
        } else {
            return this.price - b.price;
        }
    }

    @Override
    public String toString() {
        return "$" + this.price / 100 + "." + String.format("%02d", this.price % 100) + " using " + this.driver + " (" + this.serve + ")";
    }
}
