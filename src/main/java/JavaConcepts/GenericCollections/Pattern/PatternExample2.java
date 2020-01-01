package JavaConcepts.GenericCollections.Pattern;

import java.util.regex.Pattern;

public class PatternExample2 {

    public static void main(String[] args) {
        String text = "Егор Алла Анна";
        Pattern pattern = Pattern.compile("\\s");
        String [] strings = pattern.split(text,1);

        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println();

        String [] strings1 = pattern.split(text);
        for (String s: strings1) {
            System.out.println(s);
        }
        System.out.println("3 index of word "+strings1[2]);
        System.out.println("3 index of word "+strings[0]);
    }
}
