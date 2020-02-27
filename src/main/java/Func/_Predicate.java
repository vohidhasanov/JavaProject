package Func;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        //Without predicate
        System.out.println(isPhoneNumber("07000000000"));
        //with Predicate
        System.out.println(isPhoneNumberPredicate.test("07000000000"));
        //Chaining Predicat
        System.out.println("Is phone number contains 3 "+ isPhoneNumberPredicate.and(contain3).test("07000000000"));
        System.out.println("Is phone number contains 3 " + isPhoneNumberPredicate.and(contain3).test("07000000003"));


    }

    static boolean isPhoneNumber (String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length()==11;
    }

    static Predicate<String> isPhoneNumberPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length()==11;
    static Predicate <String> contain3 = phoneNumber -> phoneNumber.contains("3");
}

