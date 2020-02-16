public class SolidSphere {
  private final double radius;
  private final double density;

  public SolidSphere(double r, double d) {
    this.radius = r;
    this.density = d;
  }

  public SolidSphere setRadius(double r) {
    return new SolidSphere(r, density);
  }

  public double getSurfaceArea() {
    return 4 * Math.PI * radius * radius;
  }

  public double getVolume() {
    return (4.0 / 3.0) * Math.PI * radius * radius * radius;
  }

  public double getDensity() {
    return density;
  }

  public double getMass() {
    return density * getVolume();
  }

  public String toString() {
    return String.format("SolidSphere [%.2f] with a mass of %.2f", radius, getMass());
  }
}