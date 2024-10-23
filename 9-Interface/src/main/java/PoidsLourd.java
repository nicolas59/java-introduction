public class PoidsLourd extends Vehicule
        implements AutoRoute {

    public PoidsLourd(String modele, int nbEssieux) {
        super(modele, nbEssieux);
    }

    @Override
    public int getCategorie() {
        return 2;
    }
}
