package Func.MyWorks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JavaPredicateEx2{

    public static void main(String[] args) {
        List<Countries> countries = new ArrayList<>();
        countries.add(new Countries ("Iran", 80848713));
        countries.add(new Countries("Hungary", 9845000));
        countries.add(new Countries("Poland", 38485000));
        countries.add(new Countries("India",1342512000));
        countries.add(new Countries("Latvia",1978000));
        countries.add(new Countries("Vietnam", 92261000));
        countries.add(new Countries("Sweden", 9967000));
        countries.add(new Countries("Iceland", 3376000));
        countries.add(new Countries("Israel",8622000));

        Predicate<Countries> p1 = c -> c.getName().startsWith("I") && c.getPopulation() >10000000;
        countries.stream().filter(p1).forEach(System.out::println)  ;



    }
}
