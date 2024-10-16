import java.util.ArrayList;

public class Main6 {
    public record Country(String name, String capital){};

    public static void main(String[] args) {
        var countries = new ArrayList<Main6.Country>();
        countries.add(new Main6.Country("France", "Paris"));
        countries.add(new Main6.Country("Allemagne", "Berlin"));
        countries.add(new Main6.Country("Anglaterre", "Londres"));
        countries.add(new Main6.Country("Belgique", "Bruxelles"));

        countries.stream()
                .forEach(country -> System.out.println(country.name().toUpperCase() + " a pour capitale " + country.capital()));
    }
}
