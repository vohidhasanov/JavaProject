package Func.MyWorks;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Sample {
    private static boolean isGreaterThan3 (int number) {
        return number > 3;
    }
    private static boolean isEven (int number) {
        return number % 2==0;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
        System.out.println(isPrime(6));
        System.out.println(isPrime(7));

        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);
        //Predicate <Integer> isGraterThan3 = number -> number > 3;
        Function<Integer, Predicate<Integer>> isGreaterThan = pivot -> number -> number>pivot;
        System.out.println(
                values.stream()
                .filter (Sample::isGreaterThan3) // or same:  .filter(e -> isGreaterThan3(e))
                //.filter(isGreaterThan.apply(4)); // we can reuse this Function
                .filter(Sample::isEven)
                .map(e -> e*2)
                .findFirst()
        );
    }

    private static boolean isPrime(final int i) {
//        for (int x=2; x < i; x++) {
//            if (i % x == 0)
//                return false;
//        }
//        return i > 1;
//    }
        Predicate<Integer> isDivisible = divisor -> i % divisor == 0;
        return i > 1 &&
                IntStream.range(2, i).noneMatch(index -> i % index == 0);
         //       IntStream.range(2, i).noneMatch(index -> isDivisible(index));


    }
}
