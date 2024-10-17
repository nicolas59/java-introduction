import java.util.ArrayList;

public class Main7 {
    public record Country(String name, String capital){};

    public static void main(String[] args) {
        var countries = new ArrayList<Main7.Country>();
        countries.add(new Main7.Country("France", "Paris"));
        countries.add(new Main7.Country("Allemagne", "Berlin"));
        countries.add(new Main7.Country("Anglaterre", "Londres"));
        countries.add(new Main7.Country("Belgique", "Bruxelles"));

        countries.stream()
                .map(country -> country.name().toUpperCase() + " a pour capitale " + country.capital())
                .forEach(str -> System.out.println(str));
    }
}
