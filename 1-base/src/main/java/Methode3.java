public class Methode3 {

    public static int substract(int... numbers){
        int ret = 0;
        for(var number: numbers){
            ret -= number;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.printf("Soustraction : %d\n", substract(1,3,4,5));
        System.out.printf("Soustraction : %d", substract(9, 8));
    }
}
