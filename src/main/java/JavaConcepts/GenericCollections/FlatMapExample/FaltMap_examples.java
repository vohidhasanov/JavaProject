package JavaConcepts.GenericCollections.FlatMapExample;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FaltMap_examples {

    public static void main(String[] args) {
        Stream.of(2,3,0,1,3)
                .flatMapToInt(x-> IntStream.rangeClosed(0, x))
                .forEach(System.out::print);
    }

}
