public class Cuboid implements Shape3D {
  private final double height;
  private final double width;
  private final double length;

  public Cuboid(double h, double w, double l) {
    this.height = h;
    this.width = w;
    this.length = l;
  }

  public Cuboid setHeight(double h) {
    return new Cuboid(h, width, length);
  }

  public Cuboid setWidth(double w) {
    return new Cuboid(height, w, length);
  }

  public Cuboid setLength(double l) {
    return new Cuboid(height, width, l);
  }

  @Override
  public double getVolume() {
    return height * width * length;
  }

  @Override
  public double getSurfaceArea() {
    return (height * length + height * width + width * length) * 2;
  }

  public String toString() {
    return String.format("Cuboid [%.2f x %.2f x %.2f]", this.height, this.width, this.length);
  }
}