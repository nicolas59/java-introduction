import java.util.Arrays;
public class Exemple3 {

    public static void main(String[] args) {
        String string = "Java c'est plutôt sympa";
        System.out.println(string.length());

        String[] words = string.split(" ");
        System.out.println(Arrays.toString(words));

        String replaceWord = string.replace("Java", "JavaScript");
        System.out.println(replaceWord);

        String extractWord = string.substring(18);
        System.out.println(extractWord);

        String upper = string.toUpperCase();
        System.out.println(upper);
    }
}
