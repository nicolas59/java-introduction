import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Main1 {

    static class Personne{
        String nom;
        LocalDate dateNaissance;

        public Personne(String nom, LocalDate dateNaissance) {
            this.nom = nom;
            this.dateNaissance = dateNaissance;
        }

        @Override
        public String toString() {
            return nom + " - " + dateNaissance;
        }

        public LocalDate getDateNaissance() {
            return dateNaissance;
        }

        public String getNom() {
            return nom;
        }
    }

    public static void main(String[] args) {

        Personne donald = new Personne("donald", LocalDate.parse("1934-01-01"));
        Personne mickey = new Personne("mickey", LocalDate.parse("1928-01-01"));
        Personne dingo = new Personne("dingo", LocalDate.parse("1932-05-25"));
        List<Personne> personnages = Arrays.asList(donald, mickey, dingo);

        Comparator<Personne> compare = (p1, p2) -> p1.dateNaissance.compareTo(p2.dateNaissance);
        personnages.sort(compare);

        System.out.println(personnages);
    }
}
