import java.util.ArrayList;

public class Main8 {
    public record Country(String name, String capital){};

    public static void main(String[] args) {
        var countries = new ArrayList<Main8.Country>();
        countries.add(new Main8.Country("France", "Paris"));
        countries.add(new Main8.Country("Allemagne", "Berlin"));
        countries.add(new Main8.Country("Anglaterre", "Londres"));
        countries.add(new Main8.Country("Belgique", "Bruxelles"));

        countries.stream()
                .filter(country -> country.name().startsWith("A"))
                .map(country -> country.name().toUpperCase() + " a pour capitale " + country.capital())
                .forEach(str -> System.out.println(str));
    }
}
