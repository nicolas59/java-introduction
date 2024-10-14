package amimal;

public class Mammifere extends Animal{

    public Mammifere(String nom, int age) {
        super(nom, age);
    }

    @Override
    public final boolean isMammifere() {
        return true;
    }
}
