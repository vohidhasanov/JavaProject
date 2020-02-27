package Func.MyWorks;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Converter <T,F> {
    F convert (T form);
    static Converter <String, Integer> converter =
            //(form) -> Integer.valueOf(form);
            Integer::valueOf;

}

interface PersonFactory <P extends ConverterImp> {
    P create(String name, String lastName);
}

class ConverterImp {
    String name;
    String lastName;

    public ConverterImp () {};

    public ConverterImp(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    String startsWith (String s) {
        return String.valueOf(s.charAt(0));
    }

    public static void main(String[] args) {
        Integer converted = Converter.converter.convert("001");
        System.out.println(converted);

//        Integer s =Converter.converter.convert("Hello");
//        System.out.println(s);

        Converter <String, String> converter2 = new ConverterImp()::startsWith;
        String converted2 = converter2.convert("Java");
        System.out.println(converted2);

        PersonFactory<ConverterImp> person = ConverterImp::new;
        person.create("Peter", "Parker");

        final int i =1;

        Converter <Integer, String> stringConverter = form -> String.valueOf(form+i);
        String s = stringConverter.convert(20);
        System.out.println(s);

        Function <String, Integer> toInteger = Integer::valueOf; // x-> Integer.valueOf(x); //2-вариант
        Function <String, String> backToString = toInteger.andThen(String::valueOf);

        Supplier<ConverterImp> person2 = ConverterImp::new;
        person2.get();

        Consumer<ConverterImp> greeter = p -> System.out.println("Hello, "+ p.name);
        greeter.accept(new ConverterImp("John", "Brown"));

        Comparator <ConverterImp> comparator = (p1, p2) -> p1.name.compareTo(p2.name);

        ConverterImp a = new ConverterImp("Bobby", "Grace");
        ConverterImp b = new ConverterImp("Tommy", "Brown");

        comparator.compare(a,b);
        comparator.reversed().compare(a,b);

        Optional<String> optional = Optional.of("bam");
        optional.isPresent(); // true
        optional.get(); //bam
        optional.orElse("Falback"); //bam
        optional.ifPresent((x)-> System.out.println(x.charAt(0))); // "b"





    }
}
