import amimal.Baleine;

public class Main7 {
    public static void main(String[] args) {
        var baleine1 = new Baleine("Moby Dick", 173);
        var baleine2 = new Baleine("Moby Dick", 173);
        System.out.printf("Les baleines sont elle les meêmes ? Reponse : %b", baleine1.equals(baleine2));
    }
}