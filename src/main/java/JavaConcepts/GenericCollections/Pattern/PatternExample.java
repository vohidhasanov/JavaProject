package JavaConcepts.GenericCollections.Pattern;

import java.util.regex.Pattern;

public class PatternExample {

    public static void main(String[] args) {
        String REGEX = "(.*)(ee)(.*)";
        String actualString = "geeks";

        Pattern pattern1 = Pattern.compile(REGEX);
        String RegularExpression = pattern1.pattern();
        System.out.println("Pattern's regular expression: "+RegularExpression);



    }
}
