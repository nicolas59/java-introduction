import java.util.HashMap;
import java.util.Map;

public class Main1 {

    public static void main(String[] args) {
        // declaration de la map.
        // on indique qu'il s'git d'une map dont le type est une string
        // et la valeur sera également de type string
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "James Gosling");
        languages.put("Javascript", "Brendan Eich");
        languages.put("Python", "Guido van Rossum");
        languages.put("C", "Dennis Ritchie");

        //recherche de la valeur à partir de la clé
        String creator = languages.get("Java");
        System.out.println(creator);
    }
}
