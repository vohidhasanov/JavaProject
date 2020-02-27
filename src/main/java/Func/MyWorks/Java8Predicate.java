package Func.MyWorks;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Predicate {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "AA", "AAA", "B", "BB", "BBB");
        System.out.println(StringProcessor.filtering (list, x -> x.startsWith("A")));
    }
}
class StringProcessor {
    static List<String> filtering (List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate::test).collect(Collectors.toList());
    }
}
