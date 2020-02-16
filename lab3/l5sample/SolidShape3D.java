public class SolidShape3D extends Shape3D implements SolidProp {
    private final Shape3D shape3D;
    private final Material material;

    public SolidShape3D(Shape3D shape3D, Material material) {
        this.shape3D = shape3D;
        this.material = material;
    }

    public double getDensity() {
        return this.material.density;
    }
    
    public double getMass() {
        return this.shape3D.getVolume() * this.material.density;
    }

    public double getVolume() {
        return this.shape3D.getVolume();
    }

    public double getSurfaceArea() {
        return this.shape3D.getSurfaceArea();
    }

    @Override
    public String toString() {
        return "Solid" + shape3D.toString() +
               " with a mass of " + String.format("%.2f", this.getMass());
    }
}