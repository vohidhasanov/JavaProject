package Func.MyWorks;

import java.util.function.Function;

public class ExampleFunction {

    Function<Integer, Integer> makeAdder (int i) {
        return x -> x + i;
    }
    Function <Integer, Integer> addOne =
            makeAdder(1);

    public static void main(String[] args) {
        System.out.println(new ExampleFunction().addOne.apply(10));
        System.out.println(new ExampleFunction().makeAdder(1).apply(2));
    }
}
