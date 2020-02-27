package Func.MyWorks;

import java.math.BigDecimal;

public class Money {
    Integer amount;
    Money (Integer amount) {
        this.amount = amount;
    }

    Money add (Money other) {
        return new Money(amount + (other.amount) );
    }


    public static void main(String[] args) {
        Money s =new Money(100).add(new Money(200));
        System.out.println(s.amount);
    }
}
