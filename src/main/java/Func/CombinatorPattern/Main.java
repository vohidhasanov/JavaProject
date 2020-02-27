package Func.CombinatorPattern;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+089898755252",
                LocalDate.of(2015,1,1)
        );

        //CustomerValidatorService validaterService = new CustomerValidatorService();
        //System.out.println(validaterService.isValid(customer));

     //   System.out.println(new CustomerValidatorService().isValid(customer));
        // if customer is Valid we can store customer in DB

        //Using Combinator Pattern
        CustomerRegistrationValidator.ValidationResult result =
                      CustomerRegistrationValidator.isEmailValid()
                .and(CustomerRegistrationValidator.isPhoneNumberValid())
              // .and(CustomerRegistrationValidator.isAnAdult())
                .apply(customer);

            System.out.println(result);

            if (result!= CustomerRegistrationValidator.ValidationResult.SUCCESS) {
                throw new IllegalStateException(result.name());
            }

    }
}
