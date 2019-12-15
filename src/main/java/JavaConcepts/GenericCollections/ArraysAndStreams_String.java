package JavaConcepts.GenericCollections;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams_String {

    public static void main(String[] args) {
        String [] strings = {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Viole"};
        System.out.printf("Original Strings: %s%n", Arrays.asList(strings));

        System.out.printf("stings in uppercase: %s%n",
                Arrays.stream(strings)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList()));

        //strings less than 'n' (case insensitive) sorted ascending
        System.out.printf("strings greater than m sorted ascending: %s%n",
                Arrays.stream(strings)
                    .filter(s -> s.compareToIgnoreCase("n") >0)
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList()));

        System.out.printf("strings greater than m sorted descending: %s%n",
                Arrays.stream(strings)
                    .filter(s->s.compareToIgnoreCase("n") >0)
                    .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                    .collect(Collectors.toList()));




    }
}
