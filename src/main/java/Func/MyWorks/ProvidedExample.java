package Func.MyWorks;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Predicate;

interface Provided <T,R> extends Function <Predicate<T>, Function <Function<T,R>, Function <Function <T,R>, Function <T,R>>>>
{
    static <T,R> Provided <T,R> create () {
        return
                condition ->
                        function ->
                                fall ->
                                        arg->
                                                (condition.test(arg) ?  function : fall).apply(arg);

    }


    static <T,R> Function <T,R> decorate (Predicate <T> condition, Function <T,R> function, Function <T,R> fallback ) {
        return Provided.<T,R> create()
                .apply(condition)
                .apply(function)
                .apply(fallback);
}
}

public class ProvidedExample {
    private void demo() {
        System.out.println("--------------------");
        System.out.println("Starting PROVIDING");
        System.out.println("--------------------");

        Function <BigDecimal, String> addTaxDecorated =
                Provided.decorate (
                        this::isTaxable,
                        this:: addTax,
                        this::fallback
                );

        String result1 = addTaxDecorated.apply(new BigDecimal("100"));
        System.out.println("Done - Result is: " + result1);
        System.out.println("-----------------------------");

        String reslut2 = addTaxDecorated.apply(new BigDecimal("5"));
        System.out.println("Done - Result is: " + reslut2);
        System.out.println("-----------------------------");
    }
    private boolean isTaxable (BigDecimal argument) {
        boolean condition = argument.compareTo(BigDecimal.TEN) >=0;
        System.out.println("PROVIDED: Argument is " + argument + " , conditon is "+ condition);
        return condition;
    }

    private String addTax (BigDecimal amount) {
        System.out.println("Adding new taxes to poor citizen...");
        return "$" + amount.multiply(new BigDecimal("1.22"));
    }

    private String fallback (BigDecimal amount) {
        System.out.println("Fallback tax eemption");
        return "$" + amount;
    }


    public static void main(String[] args) {
        new ProvidedExample().demo();
    }


}
