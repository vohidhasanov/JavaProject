package Func.MyWorks;


import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

interface Postcondition <T, R, X extends RuntimeException> extends Function <Function <T,R>,
                                                                    Function <BiPredicate<T,R>,
                                                                    Function <BiFunction<T,R,X>,
                                                                    Function <T,R>>>>
{
    static <T,R, X extends RuntimeException> Postcondition <T,R, X> create () {
        return function ->
                condition ->
                    error ->
                            After.decorate(function,
                                    (argument, result) -> {
                                    if (!condition.test(argument,result)) {
                                        throw error.apply(argument, result);
                                    }
        });
    }

    static <T,R,X extends RuntimeException> Function <T,R> decorate (
                                                Function <T,R> function,
                                                BiPredicate <T,R> condition,
                                                BiFunction <T,R,X> error ){
        return Postcondition.<T,R,X> create()
                                    .apply(function)
                                        .apply(condition)
                                            .apply(error);

        }
    }


public class PostconditionExample {
    void demo () {
        System.out.println("-----------------------------------------");
        System.out.println("Starting POSTCONDITION combinator demo...");
        System.out.println("-----------------------------------------");

        Function <BigDecimal, String> addTaxDecorated1 = Postcondition.decorate (
                    this::addTax,
                    this::checkResultStartsWith$,
                    InvalidTaxResultFormatException ::new);

        String result1 = addTaxDecorated1.apply(new BigDecimal("10"));
        System.out.println("Done - Reslt is: " + result1);
        System.out.println("----------------------------------------");

        try {
            Function <BigDecimal, String> addTaxDecorated2 = Postcondition.decorate (
                    this::addTaxIncorrect,
                    this::checkResultStartsWith$,
                    InvalidTaxResultFormatException::new );
            String result2 = addTaxDecorated2.apply(new BigDecimal("10"));
            System.out.println("Done - Reslt is: " + result2);
        } catch (InvalidTaxResultFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("----------------------------------------");
    }
    private String addTax (BigDecimal amount) {
        System.out.println("Adding heavy taxes to poor citizen...");
        return "$" + amount.multiply(new BigDecimal("1.22"));
    }

    private String addTaxIncorrect (BigDecimal amount) {
        System.out.println("Incorrectly adding heavy taxes to poor citizen...");
        return "EE"+ amount.multiply(new BigDecimal("1.22"));
    }

    private boolean checkResultStartsWith$ (BigDecimal argument, String result) {
        boolean condition = result.startsWith("$");
        System.out.println("POSTCONDITION: Argument is "+ argument+" ,result is "+result+ " , condition is "+condition);
        return condition;
        }

       {

    }


    public static void main(String[] args) {
        new PostconditionExample().demo();
    }
}

 class InvalidTaxResultFormatException extends RuntimeException {

    private InvalidTaxResultFormatException (String message) {
    super(message);
    }
        public InvalidTaxResultFormatException ( BigDecimal amount, String formatted) {
        this ("Result of adding tax to amount " + amount + " has incorrect format: " + formatted);
}
}
