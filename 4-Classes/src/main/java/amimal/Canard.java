package amimal;

public class Canard extends Animal {

    private String couleurBec;

    public Canard(String nom, int age, String couleurBec) {
        super(nom, age);
        this.couleurBec = couleurBec;
    }

    public void nage() {
    }

    @Override
    public boolean isMammifere() {
        return false;
    }
}
