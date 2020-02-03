package JavaConcepts.GenericCollections.FlatMapExample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Human {

    private final String name;
    private final List<String> pets;

    public Human(String name, List<String> pets) {
        this.name = name;
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public List<String> getPets() {
        return pets;
    }

    public static void main(String[] args) {
        List <Human> humans = asList (
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        List <String> petNames = new ArrayList<>();
        for (Human human : humans) {
            petNames.addAll(human.getPets());
        }
     //   System.out.println(petNames);


        List <String> petName1 = humans.stream()
                .map(human -> human.getPets())
                .flatMap(pets -> pets.stream())
    //            .flatMap(Collection::stream)
//                .flatMap(human->human.getPets().stream())  // Compact variant
                .collect(Collectors.toList());
        System.out.println(petName1);


    }
}
