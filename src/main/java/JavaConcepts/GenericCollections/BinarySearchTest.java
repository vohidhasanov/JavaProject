package JavaConcepts.GenericCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {

    public static void main(String[] args) {
        String [] colors = {"red", "white", "blue", "black", "yellow", "purple", "tan", "pink"};
        List<String> list=new ArrayList<>(Arrays.asList(colors));
        Collections.sort(list);
        System.out.printf("Sorted Array list: %s%n", list);

        printSerarchResults(list, "black");
        printSerarchResults(list, "red");
        printSerarchResults(list, "pink");
        printSerarchResults(list, "aqua");

    }

    private static void printSerarchResults(List<String> list, String key) {
        int result = 0;

        System.out.printf("%nSearching for: %s%n", key);
        result=Collections.binarySearch(list, key);

        System.out.printf((result>0)? "Found at index %d%n" : "Not found (%d)%n", result);

    }
}
