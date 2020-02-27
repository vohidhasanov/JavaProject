package Func;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
    int increment = incrementByOneFunction.apply(1);
        System.out.println(increment);
    int increment2 = incrementByOneFunction.apply(1);
        System.out.println("increment2: "+ increment2);
    int multipleBy10 = multiplyBy10Function.apply(increment2);
        System.out.println("multipleBy10: "+multipleBy10);

        Function <Integer, Integer> addByOneAndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println("AndThen function: "+ addByOneAndThenMultiplyBy10.apply(4));
        //BiFunction example
        int i = incrementByOneAndMultiplyBiFunction.apply(4,100);
        System.out.println("Using BiFunction: "+ i);



    }

    static Function<Integer, Integer> incrementByOneFunction =number->number+1;
    static Function <Integer, Integer> multiplyBy10Function = number->  number*10;
    static BiFunction <Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy)-> (numberToIncrementByOne+1)*numberToMultiplyBy;
}
