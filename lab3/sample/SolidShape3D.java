public class SolidShape3D {
  private Material material;
  private Shape3D shape;

  public SolidShape3D(Shape3D shape, Material material) {
    this.material = material;
    this.shape = shape;
  }

  public double getMass() {
    return shape.getVolume() * material.getDensity();
  }

  public double getDensity() {
    return material.getDensity();
  }

  public String toString() {
    return String.format("Solid%s with a mass of %.2f", shape.toString(), getMass());
  }

}