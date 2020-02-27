package Func.MyWorks;



import com.sun.security.jgss.GSSUtil;

import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Predicate;

interface Precondition <T,R, X extends RuntimeException> extends Function<
                                                                    Predicate<T>,
                                                                    Function <Function<T,R>,
                                                                    Function <Function <T,X>,
                                                                    Function <T,R>>>> {

    static <T,R,X extends RuntimeException> Precondition <T,R, X> create() {
        return
                condition ->
                        function ->
                                error ->
                                        Provided.decorate (
                                    condition,
                                                function,
                                                arg -> {
                                                    throw error.apply(arg);
                                                }
        );
    }

    static <T,R,X extends RuntimeException> Function <T,R> decorate (Predicate <T> condition,
                                                                     Function <T,R> function,
                                                                     Function <T,X> error) {
        return
                Precondition.<T,R, X> create()
                        .apply(condition)
                        .apply(function)
                        .apply(error);

    }

}

public class PreconditionExample {
    void demo() {
        System.out.println("----------------------");
        System.out.println("Startind PRECONDITION");
        System.out.println("----------------------");

        Function <BigDecimal, String> addTaxDecorated =
                Precondition.decorate (
                        this::isGreaterThanZero,
                        this::addTax,
                        NonPositiveAmountTaxException::new
                );

        String result1 = addTaxDecorated.apply(new BigDecimal ("-10"));
        System.out.println("Done result is: " + result1);
        System.out.println("==============================");

        try {
            String result2 = addTaxDecorated.apply(new BigDecimal("-5"));
            System.out.println("Done result is: " + result2);
        } catch (NonPositiveAmountTaxException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("=================================");
    }

    private boolean isGreaterThanZero (BigDecimal argument) {
        boolean condition = argument.compareTo(BigDecimal.ZERO) > 0;
        System.out.println("PRECONDITION Argument is " + argument + ", conditon is " + condition);
        return condition;
    }

    private String addTax (BigDecimal amount) {
        System.out.println("Adding heavy taxes to poor citizen...");
        return "$" + amount.multiply(new BigDecimal("1.22"));
    }

    public static void main(String[] args) {
        new PreconditionExample().demo();
    }
}

class NonPositiveAmountTaxException extends RuntimeException {

    private NonPositiveAmountTaxException (String message) {
        super (message);
    }
    public NonPositiveAmountTaxException (BigDecimal amount) {
        this ("Amount to be taxed must be > 0 but was " + amount);
    }


}