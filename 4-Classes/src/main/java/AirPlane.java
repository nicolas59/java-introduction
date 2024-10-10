public class AirPlane {

    // 1 déclaration des attributs / propriété
    private String brand;
    private String model;
    private int capacity;
    private double speed;
    private double elevation;

    public AirPlane(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public AirPlane(String brand) {
        this.brand = brand;
    }

    public void decelerate(double speeValued) {
        if (this.speed - speeValued > 0) {
            this.speed -= speeValued;
        }
    }

    public void accelerate(double speeValued) {
        this.speed += speeValued;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getCapacity() {
        return capacity;
    }

    public double getElevation() {
        return elevation;
    }


    public double getSpeed() {
        return speed;
    }

}
