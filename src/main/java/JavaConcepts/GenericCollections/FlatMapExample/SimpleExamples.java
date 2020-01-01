package JavaConcepts.GenericCollections.FlatMapExample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class SimpleExamples {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        List <Integer> twoEvenSquars = numbers.stream()
                                        .filter(n-> {
                                            System.out.println("Filtering "+n);
                                            return n%2==0;  })
                                        .map(n-> {
                                            System.out.println("Mapping "+n);
                                            return n*n;
                                        }).limit(2)
                                        .collect(toList());

       // System.out.println(twoEvenSquars);

        List <String> words = Arrays.asList("Oracle", "Java", "Magazine");
        List<Integer> wordLength = words.stream()
                                    .map(String::length)  // another way with lambda s -> s.length()
                                    .collect(toList());

        System.out.println(wordLength);

    }
}
