package Func;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        //Normal java Function
        Customer Maria = new Customer("Maria", "999-99-99");
        greetCustomer(Maria);
        //Customer Functional Interface
        Customer Bob = new Customer("Bob", "888-88-888");
        greetCustomerConsumer.accept(Bob);

        //BiCustomer Functional Interface
        greetCustomerConsumerV2.accept(Maria, false);

    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number: "+ (showPhoneNumber ? customer.customerPhoneNumber:" ******* "));

    static Consumer <Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName
            + ", thanks for registering phone number: "+ customer.customerPhoneNumber);

    static void greetCustomer (Customer customer) {
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number: "+ customer.customerPhoneNumber);
    }

    static class Customer
    {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber)
        {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

}


