package animal;

import java.util.Objects;
import java.util.StringJoiner;

public abstract class Animal  {

    private String nom;
    private int age;
    private String genre;

    public Animal(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public abstract boolean isMammifere();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(nom, animal.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, age);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("age=" + age)
                .add("nom='" + nom + "'")
                .toString();
    }

}
