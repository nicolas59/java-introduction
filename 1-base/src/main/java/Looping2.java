public class Looping2 {

    public static void main(String[] args) {
        for(int nombre=0; nombre<5; nombre++){
            if(nombre % 2 == 0){
                System.out.printf("Le nombre %d est un nombre pair.\n", nombre);
            }else{
                System.out.printf("Le nombre %d est un nombre impair.\n", nombre);
            }
        }
    }
}
