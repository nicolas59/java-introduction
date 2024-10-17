import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Saisissez un mot : ");
        var mot = scanner.next();
        System.out.println("Résultat : " + mot);

        System.out.print("Saisissez un nombre : ");
        var nb = scanner.nextInt();
        System.out.println("Résultat  : " + nb);

        //pour forcer le scanner à lire jusqu'au retour charriot
        scanner.useDelimiter(System.getProperty("line.separator"));
        System.out.print("Saisissez une phrase : ");
        var phrase = scanner.next();
        System.out.println("Résultat : " + phrase);
    }
}
