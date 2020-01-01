package JavaConcepts.GenericCollections.StreamExamples;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample_1 {

    public static void main(String[] args) {
        String [] array = {"Java", "Ruuush"};
        Stream <String> streamOfArray = Arrays.stream(array);
        streamOfArray
                .map(s -> s.split(""))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList()).forEach(System.out::print);

      //  System.out.println(streamOfArray);


    }
}
