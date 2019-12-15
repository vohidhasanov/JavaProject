package JavaConcepts.Lambda_Streams;

import java.util.stream.Stream;

public class Phone {
    private String name;
    private int price;

    public Phone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Stream<Phone> phoneStream = Stream.of(
                new Phone("I phone 6S", 54000),
                new Phone("Lumia 950", 45000),
                new Phone("Samsung galaxy S6", 40000),
                new Phone("LG F4", 32000)
                    );

        int sum = phoneStream.reduce(0,
                (x,y) ->
                {
                 if (y.getPrice()<54000)
                     return x + y.getPrice();
                 else
                     return x+0;
                },
                (x,y) -> x-y*2  );

        System.out.println(sum);
    }
}

