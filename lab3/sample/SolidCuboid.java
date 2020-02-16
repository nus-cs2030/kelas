public class SolidCuboid {
  private final double height;
  private final double width;
  private final double length;
  private final double density;

  public SolidCuboid(double h, double w, double l, double d) {
    this.height = h;
    this.width = w;
    this.length = l;
    this.density = d;
  }

  public SolidCuboid setHeight(double h) {
    return new SolidCuboid(h, width, length, density);
  }

  public SolidCuboid setWidth(double w) {
    return new SolidCuboid(height, w, length, density);
  }

  public SolidCuboid setLength(double l) {
    return new SolidCuboid(height, width, l, density);
  }

  public double getVolume() {
    return height * width * length;
  }

  public double getSurfaceArea() {
    return (height * length + height * width + width * length) * 2;
  }

  public double getMass() {
    return getVolume() * density;
  }

  public double getDensity() {
    return density;
  }

  public String toString() {
    return String.format("SolidCuboid [%.2f x %.2f x %.2f] with a mass of %.2f", height, width, length, getMass());
  }
}