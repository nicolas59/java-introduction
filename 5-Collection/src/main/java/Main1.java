import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("pomme");
        list.add("melon");
        list.add("orange");
        list.add("cerise");
        list.add("fraise");
        String pomme = list.get(0);
        System.out.println(pomme);
        System.out.printf("Taille : %d\n", list.size());
        String orange = list.remove(2);
        System.out.println(orange);
        System.out.printf("Taille : %d", list.size());
    }
}
