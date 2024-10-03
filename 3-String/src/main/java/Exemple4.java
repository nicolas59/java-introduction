public class Exemple4 {

    public static void main(String[] args) {
        var phrase = "parcourons les caractères";
        for(int index=0;index<phrase.length();index++){
            System.out.printf("%c ", phrase.charAt(index));
        }
        System.out.println("");
        var tableauChar = phrase.toCharArray();
        for(var car:tableauChar){
            System.out.printf("%c ", car);
        }
        System.out.println("");
        phrase.chars().forEach(c ->  System.out.printf("%c ", c));
    }
}
