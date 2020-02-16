public class SolidCuboid extends Cuboid implements SolidProp {
    private double density;

    public SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length);
        this.density = density;
    }

    public double getDensity() {
        return this.density;
    }

    public double getMass() {
        return this.getVolume() * density;
    }

    public SolidCuboid setHeight(double height) {
        return new SolidCuboid(height, this.width, this.length, this.density);
    }

    public SolidCuboid setWidth(double width) {
        return new SolidCuboid(this.height, width, this.length, this.density);
    }
    
    public SolidCuboid setLength(double length) {
        return new SolidCuboid(this.height, this.width, length, this.density);
    }

    @Override
    public String toString() {
        return "Solid" + super.toString() +
               " with a mass of " + String.format("%.2f", this.getMass());
    }
}