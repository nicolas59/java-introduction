import animal.Animal;
import animal.Baleine;

import java.util.HashSet;
import java.util.Set;

public class Main8 {
    public static void main(String[] args) {
        var baleine1 = new Baleine("Moby Dick", 173);
        var baleine2 = new Baleine("Moby Dick", 173);

        Set<Animal> set = new HashSet<>();
        set.add(baleine1);
        set.add(baleine2);

        System.out.printf("Nombre d'éléments : %d",  set.size());
    }
}
