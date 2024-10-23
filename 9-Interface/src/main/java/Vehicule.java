import java.util.StringJoiner;

public class Vehicule {

    private String modele;

    private int nbEssieux;

    public Vehicule(String modele, int nbEssieux) {
        this.modele = modele;
        this.nbEssieux = nbEssieux;
    }

    public String getModele() {
        return modele;
    }

    public int getNbEssieux() {
        return nbEssieux;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vehicule.class.getSimpleName() + "[", "]")
                .add("modele='" + modele + "'")
                .add("nbEssieux=" + nbEssieux)
                .toString();
    }
}
