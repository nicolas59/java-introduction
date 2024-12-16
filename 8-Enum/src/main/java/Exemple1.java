public class Exemple1 {
    public static void main(String[] args) {
        var saisons = Saison.values();
        for (Saison s : saisons) {
            System.out.println(s);
        }

        var saison = Saison.AUTOMNE; //resolution pqr une valeur de l'énumération

        var automne = Saison.valueOf("AUTOMNE"); // résolution par le nom

        if(saison == automne) {
            System.out.println("C'est bien l'automne");
        }
    }
}
