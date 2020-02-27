package Func.MyWorks.Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class  NamePred {

    public static void main(String[] args) {

       Collection names =
               (Arrays.asList("Heinz", "Helene", "Maxi", "Connie", "Bangie", "Efi"));

       Collection names2 = new ArrayList();
               names2.addAll(Arrays.asList("Heinz", "Helene", "Maxi", "Connie", "Bangie", "Efi"));

        boolean testName =  names2.removeIf(new Predicate <String> () {
             public boolean test (String s)  {
                return s.contains("i");
            }
        });
        System.out.println(testName);

         List <Integer> strLen = (List<Integer>) names.stream().map(new Function<String, Integer> () {
             public Integer apply (String s) {
                 return s ==null ? 0 : s.length();
             }
         }).collect(Collectors.toList());

        System.out.println(strLen);
   }
}
