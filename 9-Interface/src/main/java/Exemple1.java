import java.util.ArrayList;
import java.util.List;

public class Exemple1 {

    public static void main(String[] args) {
        List<AutoRoute> items = new ArrayList<>();
        items.add(new Voiture("Peugeot 5008", 2));
        items.add(new PoidsLourd("Mercedes-Benz Actros", 3));

        for(var type : items){
            System.out.println(type + " : "+ type.getCategorie());
        }
    }
}
