package Func.Streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static Func.Streams.Gender.FEMALE;
import static Func.Streams.Gender.MALE;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("JoHn", MALE),
                new Person ("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person ("Alex", MALE),
                new Person ("Alice", FEMALE)
                );

    Set<Gender> genders = people.stream()
            .map(person -> person.gender)
            .collect(Collectors.toSet());
    people.stream()
            .map(person -> person.gender)
            .collect(Collectors.toSet())
            .forEach(System.out::println); //gender -> System.out.println(gender

     //   Function<Person, String> personStringFunction = person -> person.name;
    //    ToIntFunction<String> length = String::length;
    //    IntConsumer println = System.out::println; // x -> System.out.println (x);
        people.stream()
            //.mapToInt(person -> person.name.length())
            .map(person -> person.name)
            .mapToInt(String::length)// mapToInt(name -> name.length());
            .forEach(System.out::println);

        //Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .allMatch(person ->FEMALE.equals(person.gender)); //allMatch(personPredicate)
        System.out.println(containsOnlyFemales);

    }

    static class Person {
    private final  String name;
    private final Gender gender;

        public Person(String name, Gender gerder) {
            this.name = name;
            this.gender = gerder;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gerder=" + gender +
                    '}';
        }
    }

}

enum Gender {
    MALE, FEMALE
}


