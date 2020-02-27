package Func.FinalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    Function<String, String> upperCaseName = String::toUpperCase; // exactly as name.toUpperCase();
    //if there is more logic we should use lamda and curly braces as below

    Function<String, String> upperCaseName2 = name -> {
        if (name.isBlank()) throw new IllegalStateException ("");
        return name.toUpperCase();
    };

    BiFunction<String, Integer, String> upperCaseName3 = (name, age) -> {
        if (name.isBlank()) throw new IllegalStateException ("");
        System.out.println(age);
        return name.toUpperCase();
    };
    public static void main(String[] args) {

        

        System.out.println(new Lambdas().upperCaseName.apply("Alex"));
        System.out.println(new Lambdas().upperCaseName2.apply("John"));
        System.out.println(new Lambdas().upperCaseName3.apply("Bobby", 30));




    }
}
