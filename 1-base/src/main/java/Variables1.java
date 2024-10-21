import java.time.LocalDateTime;

public class Variables1 {

    public static void main(String[] args) {
        /**
         * Declaration  et assignement d'une variable
         */
        int magicNumber = 62;

        /**
         * Une chaine de caractères peut être concaténée à tout type d'élements
         */
        System.out.println("Le nombre magique est " + magicNumber);

        /*
         * L'utilisation de la méthode printf permet d'écrire des chaines de caractères
         * en formattant la chaine de chaine de caratères.
         */
        System.out.printf("Le nombre magique est %d", magicNumber);

        // des variable
        short year = 2024;
        char a = 'a';

        double montant = 3_000;

        long longNumber = 5_678_232;
        long longNumber2 = 5_678_232l;

        LocalDateTime now = LocalDateTime.now();

        boolean yes = true;
    }
}
