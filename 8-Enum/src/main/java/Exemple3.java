public class Exemple3 {

    public static void main(String[] args) {
        var saison = Saison.AUTOMNE;

        switch (saison) {
            case AUTOMNE:
                System.out.println("C'est l'automne");
                break;
            case HIVER:
                System.out.println("C'est hiver");
                break;
            case PRINTEMPS:
                System.out.println("C'est le printemps");
                break;
            case ETE:
                System.out.println("C'est l'été");
                break;
        }


    }
}
