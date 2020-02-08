public class NormalCab extends Driver {
    public String plate;
    public int wait;

    public NormalCab(String plate, int wait) {
        this.plate = plate;
        this.wait = wait;
    }

    @Override
    public int getWait() {
        return this.wait;
    }

    @Override
    public String toString() {
        return this.plate + " (" + this.wait + " mins away) NormalCab";
    }
}
