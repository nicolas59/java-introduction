import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Main1.Personne donald = new Main1.Personne("donald", LocalDate.parse("1934-01-01"));
        Main1.Personne mickey = new Main1.Personne("mickey", LocalDate.parse("1928-01-01"));
        Main1.Personne dingo = new Main1.Personne("dingo", LocalDate.parse("1932-05-25"));
        List<Main1.Personne> personnages = Arrays.asList(donald, mickey, dingo);

        Comparator<Main1.Personne> compare = Comparator.comparing(Main1.Personne::getDateNaissance);

        personnages.sort(compare);

        System.out.println(personnages);
    }
}
