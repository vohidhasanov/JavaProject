package Func.MyWorks;

import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.pbkdf2.Integers;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class JavaPredicateCompose {

    public static void main(String[] args) {
        int []  nums = {2, 3, 1, 5, 6, 7, 8, 9, 12};
        IntPredicate p1 = n-> n > 3;
        IntPredicate p2 = n -> n < 9;

        Arrays.stream(nums).filter(p1.and(p2)).forEach(System.out::println);
        System.out.println("-----------------------");
        Arrays.stream(nums).filter(p1.negate()).forEach(System.out::println);
    }
}
