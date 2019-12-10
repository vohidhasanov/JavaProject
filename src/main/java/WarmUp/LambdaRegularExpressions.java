package WarmUp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaRegularExpressions {

    public static void main(String[] args) {
        ArrayList <Integer> oneTo5 = new ArrayList<Integer> (Arrays.asList(1,2,3,4,5));
//         oneTo5.forEach(x->System.out.println(x*2));
//         oneTo5.forEach(x-> {if (x%2==0) System.out.println(x);});

        List<Integer> fib = new LinkedList<Integer>();
        fib = Stream.iterate(new int[] {0,1},
                t-> new int[] {t[1], t[0]+t[1]})
                .limit(100)
                .map(n-> n[0])
                .collect(Collectors.toList());
        fib.forEach(x-> System.out.println(x));





    }
}
