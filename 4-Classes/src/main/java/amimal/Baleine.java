package amimal;

public class Baleine extends Mammifere{

    private int taille;

    public Baleine(String nom, int age) {
        super(nom, age);
    }

    @Override
    public String getNom() {
        return "Baleine " + super.getNom();
    }

    public void plonge(){
    }

}
