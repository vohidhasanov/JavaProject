package Func.MyWorks;


import java.math.BigInteger;
import java.util.function.Function;
import java.util.stream.LongStream;



interface  FactTest <T,R> extends Function <T,R> {

//    static <T> void runTest (Function <T,T> fact, T n) {
//        System.out.println(n + ", factorial = " + fact.apply(n));
//    }
}

public class FactEx {

    private static class Buggy {

        static BigInteger factorial (Long n) {
            BigInteger m = LongStream
                    .rangeClosed(1, n)
                    .parallel()
                    .mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ONE, BigInteger::multiply);
        return m;}
    }

    static BigInteger factorial (Long n) {
        BigInteger m = LongStream
                .rangeClosed(1, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
        return m;}

    private <T,R> void runTest( Function<T, R> factorial,
                             T n) {
        System.out.println(n + ", factorial = " + factorial.apply(n));
    }



      void demo () {
//          Function <Long, BigInteger> fff = runTest(this::factorial, 4L));
//          fff.apply(4L);
    }

    public static void main(String[] args) {
         //BigInteger n = new BigInteger("10");
        Long l = 10L;

        FactEx f = new FactEx();
       // System.out.println(f.factorial(5L));
        Function <Long, BigInteger> mmm = FactEx::factorial;
        f.runTest(mmm, l);



    }
}


