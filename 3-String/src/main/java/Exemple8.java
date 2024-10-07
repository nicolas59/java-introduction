import java.time.Duration;

public class Exemple8 {

    static String[] items = {"Une", "chaine", "de", "caracteres"};

    static int MAX_ITERATION = 100000;

    public static void calculateDuration(String type, Runnable execute) {
        long start = System.nanoTime();
        execute.run();
        long stop = System.nanoTime();

        var duration = Duration.ofNanos(stop).minus(Duration.ofNanos(start)).toString();
        System.out.println(type + " : " + duration);
    }


    public static void concateWithPlus() {
        String ret = "";
        for (int i = 0; i < MAX_ITERATION; i++) {
            for (var item : items) {
                ret += item + " ";
            }
        }
    }

    public static void concateWithStringBuilder() {
        StringBuilder buiilder = new StringBuilder();
        for (int i = 0; i < MAX_ITERATION; i++) {
            for (var item : items) {
                buiilder.append(item).append(" ");
            }
        }
        var ret = buiilder.toString();
    }

    public static void main(String[] args) {
        calculateDuration("StringBuilder : ", Exemple8::concateWithStringBuilder);
        calculateDuration("Concaténation classique : ", Exemple8::concateWithPlus);
    }
}
