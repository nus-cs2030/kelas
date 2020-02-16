import java.lang.Math;

public class Sphere extends Shape {
    protected final double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    public double getVolume() {
        return (4.0/3.0) * Math.PI * Math.pow(this.radius,3);
    }

    public double getSurfaceArea() {
        return 4.0 * Math.PI * Math.pow(this.radius,2);        
    }

    public Sphere setRadius(double radius) {
        return new Sphere(radius);
    }

    @Override
    public String toString() {
        return "Sphere " + "[" + String.format("%.2f", this.radius) + "]";
    }
}