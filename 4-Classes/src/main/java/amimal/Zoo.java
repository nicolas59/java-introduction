package amimal;

import java.util.Arrays;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Zoo {
    private Animal[] animaux;

    public Zoo() {
        this.animaux = new Animal[100];
    }

    public void addAnimal(Animal animal, int index){
        this.animaux[index] = animal;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Zoo.class.getSimpleName() + "[", "]")
                .add("animaux=" + Arrays.stream(animaux).filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(",")))
                .toString();
    }
}
