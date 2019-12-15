package JavaConcepts.Lambda_Streams;

import org.w3c.dom.ls.LSOutput;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamExample {

    public static void main(String[] args) {
        int values [] = {3,10,6,1,4,8,2,5,9,7};

        System.out.println("Original values: ");
        IntStream.of(values)
                .forEach(value -> System.out.printf("%d ", value));
        System.out.println();

        //count min, max, sum and avertage of the values
        System.out.printf("%nCount: %d%n", IntStream.of(values).count());
        System.out.printf("Min: %d%n",
                IntStream.of(values).min().getAsInt());
        System.out.printf("Max: %d%n",
                IntStream.of(values).max().getAsInt());
        System.out.printf("Sum: %d%n",
                IntStream.of(values).sum());
        System.out.printf("Average: %.2f%n",
                IntStream.of(values).average().getAsDouble());

        //sum of values with reduce method
        System.out.printf("%nSum via reduce method: %d%n",
                IntStream.of(values).reduce(0, (x,y)-> x+y));
        // sum of squares of values with reduce method
        System.out.printf("Sum of squares via reduce method: %d%n",
                IntStream.of(values).reduce(0, (x,y)->x+y*y));

        //product of values wtih reduce method
        System.out.printf("Product via reduce method: %d%n",
                IntStream.of(values).reduce(1, (x,y)-> x*y));

        //even values displyed in sorted order
        System.out.printf("%nEven values displyed in sorted order: ");
                IntStream.of(values)
                        .filter(value1-> value1%2==0)
                        .sorted()
                        .forEach(value1-> System.out.printf("%d ", value1));
        System.out.println();

        //odd values multiplied by 10 and displayed in sorted order
        System.out.printf("Odd values multiplied by 10 displyed in sorted order: ");
                IntStream.of(values)
                        .filter(value1-> value1%2!=0)
                        .map(value1->value1*10)
                        .sorted()
                        .forEach(value1 -> System.out.printf("%d ", value1));
        System.out.println();

        //sum range of integers from 1 to 10, excluse (10 doesn't included)
        System.out.printf("%nSum of integers from 1 to 9: %d%n",
        IntStream.range(1, 10).sum());

        //sum range of integers from 1 to 10 inclusive (10 is included)
        System.out.printf("%nSum of integers from 1 to 10: %d%n",
                IntStream.rangeClosed(1,10).sum());

        IntPredicate even = value -> value%2==0;
        IntPredicate greaterThan5 = value -> value>5;

        System.out.printf("Values even and greater than 5 displayed: ");
                IntStream.of(values)
                .filter(even.and(greaterThan5))
                .sorted()
                .forEach(value-> System.out.printf("%d ", value));




     }

}
