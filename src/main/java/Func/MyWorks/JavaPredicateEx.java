package Func.MyWorks;

import java.util.List;
import java.util.function.Predicate;

class BiggerThenFive <E> implements Predicate<Integer> {
    @Override
    public boolean test(Integer v) {
        Integer five = 5;
        return v > five;
    }
}
public class JavaPredicateEx {
    public static void main(String[] args) {
        List<Integer> nums = List.of (2,3,11,5,6,7,0);
        BiggerThenFive <Integer> btf = new BiggerThenFive<>();
         // Predicate <Integer> btf2 = n -> n>5; //second way
        nums.stream()
                .filter(btf)
             //   .filter(number -> number >5)
                .forEach(System.out::println);
    }
}
