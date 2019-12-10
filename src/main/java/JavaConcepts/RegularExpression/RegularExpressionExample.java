package JavaConcepts.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExample {

    public static void main(String[] args) {
        //String line = "The order order was placed from QT3000! OK?";
        String line = "Orderorderererer orderorder";
       // String pattern = "(.*)(\\d+)(.*)";
        String pattern= "der"; //(or) (der)

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
int count=0;
       while (m.find()) {
            System.out.println("Found value : "+ m.group()+" "+m.end());
            count++;
//            System.out.println("Found value : "+m.group(1));
//            System.out.println("Found value : "+m.group(2));
        }
//        else {
//            System.out.println("NO MATCH");
//        }
        System.out.println("The number of matches: "+count);

    }
}
