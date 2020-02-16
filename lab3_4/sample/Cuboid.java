public class Cuboid extends Shape {
    protected final double height;
    protected final double width;
    protected final double length;

    public Cuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getVolume() {
        return this.height * this.width * this.length;
    }

    public double getSurfaceArea() {
        double face1 = this.height * this.width;
        double face2 = this.width * this.length;
        double face3 = this.height * this.length;
        return face1 * 2 + face2 * 2 + face3 * 2;
        
    }

    public Cuboid setHeight(double height) {
        return new Cuboid(height, this.width, this.length);
    }

    public Cuboid setWidth(double width) {
        return new Cuboid(this.height, width, this.length);
    }
    
    public Cuboid setLength(double length) {
        return new Cuboid(this.height, this.width, length);
    }

    @Override
    public String toString() {
        return "Cuboid " + "[" + String.format("%.2f", this.height) +
               " x " + String.format("%.2f", this.width) +
               " x " + String.format("%.2f", this.length) + "]";
    }
}