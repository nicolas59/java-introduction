import java.util.ArrayList;

public class Main10 {
    public record Country(String name, String capital){};

    public static void main(String[] args) {
        var countries = new ArrayList<Main10.Country>();
        countries.add(new Main10.Country("France", "Paris"));
        countries.add(new Main10.Country("Allemagne", "Berlin"));
        countries.add(new Main10.Country("Anglaterre", "Londres"));
        countries.add(new Main10.Country("Belgique", "Bruxelles"));

        var firstItem = countries.stream()
                .sorted((c1, c2) -> c1.name().compareToIgnoreCase(c2.name()))
                .findFirst();

        if(firstItem.isPresent()){
            var country = firstItem.get();
            System.out.println("Pays : " + country.name + ", Capitale : " + country.capital());
        }
    }
}
