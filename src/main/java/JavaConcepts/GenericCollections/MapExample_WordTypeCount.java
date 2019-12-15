package JavaConcepts.GenericCollections;

import java.util.*;


public class MapExample_WordTypeCount {
    public static void main(String[] args) {


    Map<String, Integer> myMap = new HashMap<>();
    createMap(myMap);
    displayMap (myMap);

}



    private static void createMap(Map<String, Integer> myMap) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        String [] tokens = input.split(" ");

        for (String token : tokens) {
            String word = token.toLowerCase();
            if (myMap.containsKey(word)) {
                int count = myMap.get(word);
                myMap.put(word, count+1);
            } else {
                myMap.put(word, 1);
            }
        }
    }

    private static void displayMap(Map<String, Integer> myMap) {
        Set<String> keys = myMap.keySet();
        TreeSet <String> sortedKeys = new TreeSet<>(keys);
        System.out.printf("%nMap contains:%nKey\t\tValue%n");

        for (String key : sortedKeys) {
            System.out.printf("%-10s%10s%n", key, myMap.get(key));
        }
        System.out.printf("%nSize: %d%nisEmpty: %b%n", myMap.size(), myMap.isEmpty());
    }
}