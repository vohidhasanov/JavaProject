package Func.Optionals;

import java.util.Optional;

public class _Optionals {

    public static void main(String[] args) {
        Object value = Optional.ofNullable(null)
                .orElseGet(()-> "defalult value");

        Object value2 = Optional.ofNullable("Hello")
                .orElseThrow(()->new IllegalStateException("exception"));

         Optional.ofNullable("John@gmail.com")
                //.ifPresent(valueOne -> {System.out.println(valueOne);}
                .ifPresent(email -> System.out.println("Sending email to "+ email));

         Optional.ofNullable(null)
                 .ifPresentOrElse(email -> System.out.println("Sending email to "+email),
                         () -> {
                             System.out.println("Cannot send email");
                         });

//         System.out.println(value);
//        System.out.println(value2);
    }
}
