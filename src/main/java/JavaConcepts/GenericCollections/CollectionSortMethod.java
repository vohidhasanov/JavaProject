package JavaConcepts.GenericCollections;

import java.util.*;

public class CollectionSortMethod {

    public static void main(String[] args) {
        String [] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        List <String> list = Arrays.asList(suits);
        System.out.printf("Unsorted array elements: %s%n", list);

        Collections.sort(list, Collections.reverseOrder());
       // Collections.so
        System.out.printf("Sorted list elements: %s%n", list);

    }


}
