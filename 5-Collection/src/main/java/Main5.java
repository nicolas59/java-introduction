import java.util.ArrayList;

public class Main5 {

    public record Country(String name, String capital){};

    public static void main(String[] args) {
        var countries = new ArrayList<Country>();
        countries.add(new Country("France", "Paris"));
        countries.add(new Country("Allemagne", "Berlin"));
        countries.add(new Country("Anglaterre", "Londres"));
        countries.add(new Country("Belgique", "Bruxelles"));

        for(var country:countries){
            System.out.println(country.name.toUpperCase() + " a pour capitale "+ country.capital);
        }

        var ret = countries.stream()
                .filter(country -> country.name.equals("France"))
                .map(country -> country.capital)
                .findFirst();

            System.out.println(ret.orElse("Inconnu"));

    }
}
