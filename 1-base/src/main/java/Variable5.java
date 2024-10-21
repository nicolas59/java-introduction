public class Variable5 {

    public static void main(String[] args) {
        //Explicit
        int value = 56;
        short castValue = (short) value;
        System.out.println(castValue);

        //Implicit
        short valueS = 56;
        int valueI = valueS;
        System.out.println(valueI);

        //Perte de precision
        int number = (int) 34.78; // numb
        System.out.println(number);
    }
}
