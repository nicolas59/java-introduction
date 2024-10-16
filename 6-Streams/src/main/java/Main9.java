import java.util.ArrayList;

public class Main9 {
    public record Country(String name, String capital){};

    public static void main(String[] args) {
        var countries = new ArrayList<Main9.Country>();
        countries.add(new Main9.Country("France", "Paris"));
        countries.add(new Main9.Country("Allemagne", "Berlin"));
        countries.add(new Main9.Country("Anglaterre", "Londres"));
        countries.add(new Main9.Country("Belgique", "Bruxelles"));

        countries.stream()
                .sorted((c1, c2) -> c1.name().compareToIgnoreCase(c2.name()))
                .map(country -> country.name().toUpperCase() + " a pour capitale " + country.capital())
                .forEach(str -> System.out.println(str));
    }
}
