package InterfaceExample.InterfaceStaticMethod;

import java.sql.SQLOutput;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public interface MyData extends Function <String, MyData.DataEnum> {
    default void print (String str) {
        if (!isNull(str)) {
            System.out.println("My Data print: "+str);
        }
    }

    static boolean isNull (String str) {
        System.out.println("Interface Null check");
        return str == null ? true : "".equals(str) ? true:false;
    }

    static MyData Hello () {
        return str -> str!="" ? DataEnum.HELLO: DataEnum.GOODBAY;

    }

    enum DataEnum {
        HELLO,
        GOODBAY
    }
}

class myDataImpl implements MyData {

    public boolean isNull (String str ) {
        System.out.println("Impl Null check");
        return str == null ? true : false;
    }

    private static boolean isPrime (int number) {
        IntPredicate isDivisible = index -> number % index == 0;
        return number >1
                && IntStream.range(2, number)
                .noneMatch(isDivisible);

    }

    public static void main(String[] args) {
        myDataImpl obj = new myDataImpl();
//        obj.print("");
//        obj.isNull("abc");
        boolean i = obj.isPrime(6);
        System.out.println(i);
        System.out.println(obj.apply("hh "));

           }


    @Override
    public DataEnum apply(String s) {
        return s==" " ? DataEnum.HELLO: DataEnum.GOODBAY;
    }
}


