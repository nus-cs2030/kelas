public class SolidSphere extends Sphere implements SolidProp {
    private final double density;

    public SolidSphere(double radius, double density) {
        super(radius);
        this.density = density;
    }

    public double getDensity() {
        return this.density;
    }

    public double getMass() {
        return this.getVolume() * density;
    }

    public SolidSphere setRadius(double radius) {
        return new SolidSphere(radius, this.density);
    }

    @Override
    public String toString() {
        return "Solid" + super.toString() +
               " with a mass of " + String.format("%.2f", this.getMass());
    }
}