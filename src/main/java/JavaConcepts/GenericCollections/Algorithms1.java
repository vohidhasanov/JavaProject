package JavaConcepts.GenericCollections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Algorithms1 {

    public static void main(String[] args) {
        Character [] letters = {'P','C','M'};
        List<Character> list = Arrays.asList(letters);
        System.out.println("list contains: "+ list);

        Collections.reverse(list);
        System.out.println("%After calling reverse, list contains:%n");

        Character [] letterCopy = new Character[3];
        List <Character> copyList = Arrays.asList(letterCopy);

        Collections.copy(copyList, list);
        System.out.printf("%nAfter copying, copylist contains:%n");
        output(copyList);

        Collections.fill(list, 'R');
        System.out.printf("%nAfter calling fill, list contains:%n");
        output(list);
    }

    private static void output(List<Character> copyList) {
        System.out.print("The list is: ");
        for (Character element : copyList)
            System.out.printf("%s ",element);

        System.out.printf("%nMax: %s", Collections.max(copyList));
        System.out.printf(" Min: %s%n", Collections.min(copyList));

    }
}
