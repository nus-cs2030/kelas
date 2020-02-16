public class Sphere implements Shape3D {
  private final double radius;

  public Sphere(double r) {
    this.radius = r;
  }

  public Sphere setRadius(double r) {
    return new Sphere(r);
  }

  @Override
  public double getSurfaceArea() {
    return 4 * Math.PI * radius * radius;
  }

  @Override
  public double getVolume() {
    return (4.0 / 3.0) * Math.PI * radius * radius * radius;
  }

  public String toString() {
    return String.format("Sphere [%.2f]", radius);
  }
}