package JavaConcepts.GenericCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {


    public static void main(String[] args) {
        String [] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN" };
        List<String> list = new ArrayList<>();

        for (String color: colors) {
            list.add(color);
        }

        String [] removeColors = {"RED", "WHITE", "BLUE"};
        List <String> removeList = new ArrayList<>();

        for (String removeColor: removeColors) {
            removeList.add(removeColor);
        }

        System.out.println("ArrayList: ");
        for (int index=0; index<list.size(); index++) {
            System.out.println(list.get(index));
        }

        removeColors(list, removeList);

        System.out.println("List of colors After Removal: ");
        for (String color: list) {
            System.out.println(color);
        }

    }

    private static void removeColors(List<String> list, List<String> removeColors) {
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            if (removeColors.contains(iterator.next()))
                iterator.remove();
        }
    }

}
