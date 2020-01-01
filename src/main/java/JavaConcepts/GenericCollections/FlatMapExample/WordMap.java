package JavaConcepts.GenericCollections.FlatMapExample;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordMap {


    public static void main(String[] args) {
        List<String> lst = Arrays.asList("STACK OOOVVEER");
       List <String> lst2 = lst.stream()
                .map(w->w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.print(lst2);

       for (String s: lst2) {
           System.out.printf("%s",s);
       }



    }
}
