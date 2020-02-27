package Func.MyWorks;

import java.math.BigDecimal;
import java.util.function.Consumer;
import java.util.function.Function;

interface Before <T,R> extends Function<Consumer<T>, Function <Function <T,R>, Function <T,R>>> {
 //Before interface extends Function Interface, (Before is a function here)
 //Before accepts Consumer<T> and Function <T,R> as arguments and returns as a result Function <T,R>
    static <T,R> Before <T,R> create() {
// factory method "create()" returns instance of Before functional interface-which is a function that accepts
//consumer named "before" and function named "function" as its arguments and returns function as a result
//this result function accepts an argument named "argument" which first passed to "before" consumer and then
//--passed to function "function", Finally the value returned by "function" is returned
        return before->
                        function->
                        argument-> {
                    before.accept(argument);
                    return function.apply(argument);  };
    }
// The "decorate" method invokes the "create()" factory method and binds "before" and "function" arguments to the returned "Before" combinator
//
    static <T,R> Function <T,R> decorate ( Consumer<T> before, Function <T,R> function) {
        return Before.<T,R> create()
                .apply(before)
                    .apply(function);
    }    }

public class BeforeExample {
        void demo () {
            System.out.println("-------------------------------------");
            System.out.println("Starting BEFORE combinator demo..");
            System.out.println("-------------------------------------");

            Function<BigDecimal, String> addTax1 = this::addTax;

            Consumer<BigDecimal> before = this::before;

            Function<BigDecimal, String> addTaxDecorated = Before.decorate(before, addTax1);
            BigDecimal argument = new BigDecimal("100");
            String result = addTaxDecorated.apply(argument);
            System.out.println("Done- Result is: " + result);
        }

        private void before (BigDecimal argument){
        System.out.println("BEFORE: Argument is " + argument);
    }
        private String addTax (BigDecimal amount){
            System.out.println("Adding heavy taxes to poor citizen...");
            return "$" + amount.multiply(new BigDecimal("1.22"));
        }

    public static void main(String[] args) {
        new BeforeExample().demo();
    }
    }

