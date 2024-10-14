package amimal;

public class Cheval extends Animal{
    private int poids;

    public Cheval(String nom, int age, int poids) {
        super(nom, age);
        this.poids = poids;
    }

    @Override
    public boolean isMammifere() {
        return true;
    }
}
