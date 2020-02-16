public class Material {
  private String name;
  private double density;

  public Material(String name, double density) {
    this.name = name;
    this.density = density;
  }

  public double getDensity() {
    return density;
  }

  public String getName() {
    return name;
  }

  // public String toString() {
  // return String.format("%s ")
  // }
}