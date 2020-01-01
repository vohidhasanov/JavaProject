package JavaConcepts.GenericCollections.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample {

    public static void main(String[] args) {
        String text = "Егор Алла Анна";
        Pattern pattern = Pattern.compile("А.+?а");

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Sovpadinie naydeno: "+text.substring(start,end)+ " s "+start+" po "+ (end-1)+" position");
               }

        System.out.println(matcher.replaceFirst("Ira"));
       // System.out.println(matcher.appendTail("IRa"));
        System.out.println(matcher.replaceAll("Olga"));
        System.out.println(text);

    }

}
