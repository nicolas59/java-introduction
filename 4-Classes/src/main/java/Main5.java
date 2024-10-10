public class Main5 {

    public static void main(String[] args) {
        AirPlane a310 = new AirPlane("Airbus", "A310");
        a310.accelerate(200);
        a310.decelerate(20);
        System.out.printf("Avion %s %s a une vitesse de %.2f \n", a310.getBrand(), a310.getModel(), a310.getSpeed());
    }
}
