import java.util.HashMap;

public class Main2 {

    public record Country(String name, String capital, Long population) {
    }

    public static void main(String[] args) {
        var countries = new HashMap<String, Country>();
        countries.put("France", new Country("France", "Paris", 68_000_000L));
        countries.put("Allemagne", new Country("Allemagne", "Berlin", 84_000_000L));
        countries.put("Anglaterre", new Country("Angleterre", "Londres", 57_000_000L));
        countries.put("Belgique", new Country("Belgique", "Bruxelles", 12_000_000L));

        for (var country : countries.entrySet()) {
            System.out.println(country.getKey() + " : \t "+ country.getValue());
        }
    }
}
