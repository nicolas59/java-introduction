import java.util.Arrays;

public class Exemple8 {
    public static void main(String[] args) {
        String[] languages  =  {"Java", "Python", "Rust", "C++"};
        Arrays.sort(languages, (a,b) -> a.length() - b.length()); //Comparator.comparing(String::length)
        System.out.println(Arrays.toString(languages));
    }
}
