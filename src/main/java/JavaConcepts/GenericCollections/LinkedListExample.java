package JavaConcepts.GenericCollections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample {

    private static void convertTuUpperCaseStrings (List<String> list) {
        ListIterator <String> iterator = list.listIterator();
        while (iterator.hasNext()) {
         String color = (String) iterator.next();
         iterator.set(color.toUpperCase());
        }
    }

    private static void removeItems(List <String> list, int start, int end) {
        list.subList(start,end).clear();
    }

    private static void printList (List <String> list) {
        System.out.printf("%nlist:%n");
        for (String color : list) {
            System.out.printf("%s ", color);
           // System.out.println();
        }
    }

    private static void printReversalList (List<String> list) {
        ListIterator <String> iterator = list.listIterator(list.size());
        System.out.printf("%nReversed List:%n");

        while (iterator.hasPrevious()) {
            System.out.printf("%s ", iterator.previous());
      //      System.out.println();
        }
    }


    public static void main(String[] args) {
        String [] colors = {"black", "yellow", "green", "blue", "violet", "silver"};
        List<String> list1 = new LinkedList<>();
        for (String color: colors) {
            list1.add(color);
        }

        String [] colors1 = {"gold", "white", "brown","blue", "grey", "silver"};
        List <String> list2 = new LinkedList<>();
        for (String color : colors1) {
            list2.add(color);
        }

        list1.addAll(list2);
        list2=null;
        convertTuUpperCaseStrings(list1);
        printList(list1);
        removeItems(list1, 1, 3);
        //printReversalList(list1);
        printList(list1);


    }
}
