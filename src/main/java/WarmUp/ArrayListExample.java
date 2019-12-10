package WarmUp;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class ArrayListExample {

    public static void main(String[] args) {
        List<Integer> oneto10 = IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        List<Integer> squares = oneto10.stream().map(x->x*x).collect(Collectors.toList());
       // for (Integer x : squares) { System.out.println(x); }

        List<Integer> even = oneto10.stream().filter(x -> (x%2)==0).collect(Collectors.toList());
      //  for (Integer x: even) { System.out.println(x); }

        IntStream limit5 = IntStream.range(1,10).limit(5);
        //limit5.forEach(System.out::println);

        int multAll = IntStream.range(1,5).reduce(1,(x,y)->x*y);
        System.out.println(multAll);

        DoubleStream stream = IntStream.range(1,5).mapToDouble(i -> i);
        IntSummaryStatistics iStats = IntStream.range(1,10).summaryStatistics();
        System.out.println(iStats.getAverage());
        System.out.println(iStats.getSum());
        System.out.println(iStats.getMin());
        System.out.println(iStats.getMax());


//        List<Integer> oneto5 = new ArrayList<Integer>{1,2,3,4,5}.
//        oneto5.forEach(x-> System.out.println(x*2));
    }
}
