package fr.epsi;

public class MyResource implements AutoCloseable {
    public void doStuff() {
        System.out.println("Je travaille....");
    }

    @Override
    public void close() {
        System.out.println("Good bye ! J'ai libéré des ressources");
    }
}
