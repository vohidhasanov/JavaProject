package Streams;

import oracle.sql.Mutable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTester {
    Mutable  people;

    public static void main(String[] args) {
        List<Person> persons = createData();


        // do any of the person have a cat?
        boolean result = persons.stream().anyMatch(person -> person.hasPets(PetType.CAT));

        // how many people have cat?
        long catCount = persons.stream().filter(person -> person.hasPets(PetType.CAT)).count();
        // who has cat>
        List<Person> peopleWithCats = persons.stream().filter(person -> person.hasPets(PetType.CAT)).collect(Collectors.toList());
        // who doesn't have a cat
        List<Person> peopleWithOutCats = persons.stream().filter(person -> !person.hasPets(PetType.CAT)).collect(Collectors.toList());
        // partion people with/without cats
        Map<Boolean, List<Person>> catsAndNoCats = persons.stream().collect(Collectors.partitioningBy(person -> person.hasPets(PetType.CAT)));
        System.out.println("People who have and don't have cats: " + catsAndNoCats);
        // get the name of Tim cats
        Person person = persons.stream().filter(each -> each.isNamed("Tim Taller")).findFirst().get();
        boolean test = ("Dolly & Spot").equals(person.getPets().stream().map(Pet::getName).collect(Collectors.joining(" & ")));
        System.out.println("Tim has Dolly & Spot: " + test);
        // get the set of all pet types
        Set<PetType> allPetTypes = persons.stream().flatMap(p -> p.getPetType().stream()).collect(Collectors.toSet());
        // System.out.println(allPetTypes);
        //group people by their last name
        Map<String, List<Person>> byLastName = persons.stream().collect(Collectors.groupingBy(Person::getLastName));
        Map<String, List<Person>> byLastNameTargetBag = persons.stream().collect(Collectors.groupingBy(Person::getLastName));
        System.out.println(byLastName);

        //get the age statistics of pets
        List<Integer> ageList = persons.stream().flatMap(p -> p.getPets().stream()).map(Pet::getAge).collect(Collectors.toList());
        IntSummaryStatistics stats = ageList.stream().collect(Collectors.summarizingInt(i -> i));
        System.out.println("Min " + stats.getMin() + " Max" + stats.getMax() + " Average " + stats.getAverage());

        // count by pet age
        Map<Integer, Long> counts = Collections.unmodifiableMap(persons.stream().flatMap(p -> p.getPets().stream())
                .collect(Collectors.groupingBy(Pet::getAge, Collectors.counting())));

        System.out.println("Count by pet age: " + counts);

    }


    public static List <Person> createData() {
        return Arrays.asList(
                new Person ("Mary", "Smith").addPet(PetType.CAT,"Tabby", 2),
                new Person ("Tim", "Taller").addPet(PetType.CAT, "Dolly", 3).addPet(PetType.DOG, "Spot",3),
                new Person ("Ted", "Smith" ).addPet(PetType.DOG, "Spike", 4 ),
                new Person ("Jake", "Snake").addPet(PetType.DOG, "Sergy",1),
                new Person ("Lars", "Voget").addPet(PetType.BIRD, "Twirly",1),
                new Person("Harry", "Hamster").addPet(PetType.HAMSTER, "Fuzzy",1).addPet(PetType.HAMSTER, "Wyzzy",1)
        );
    }

}





//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        Random random = new Random() ;
//        List<Task> values = new ArrayList<>();
//        IntStream.range(1, 20).forEach(i -> values.add(new Task("Task"+ random.nextInt(10), random.nextInt(10))));
//
//        // get a list of the distinct task summary field
//        List<String> resultList = values.stream().filter(t-> t.getDuration()>5)
//                                    .map(t-> t.getSummary()).distinct().collect(Collectors.toList());
//        System.out.println(resultList);
//
//        //get a contacenated string of Task with the duration longer than 5 hours
//        String collect = values.stream().filter(t -> t.getDuration()>5)
//                            .map(t-> t.getSummary()).distinct().collect(Collectors.joining("-"));
//        System.out.println(collect);
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//        List<String> list = Arrays.asList("Hello", "Streams","Not");
//        String result =  list.stream().filter(s-> s.contains("e"))
//                        .map(s -> s.toUpperCase())
//                        .reduce("", (a,b) -> a + " " + b);
//
//        System.out.println(result+ "!");
//

//    }
//}
