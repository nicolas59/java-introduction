package fr.epsi;

public class Main5 {

    public static void main(String[] args) {
        try (var resource = new MyResource();
             var resource2 = new MyResource();
        ) {
            resource.doStuff();
        }
    }
}
