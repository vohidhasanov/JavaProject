package WarmUp;

import java.util.ArrayList;
import java.util.Arrays;

public class Genirics {

    public static void main(String[] args) {
        String [] a1 = {"one", "two"};
        Integer [] a2 = {1,2,3,4};
//        printStuff(a1);
//        printStuff(a2);

        ArrayList<Integer> aL1 = new ArrayList <> (Arrays.asList(1,2,3,4));
        printAl(aL1);

        MyGeneric <Integer> myGI = new MyGeneric<>();
        myGI.setVal(10);
        System.out.println(myGI.getVal());

        MyGeneric <String> myGI2 = new MyGeneric<>();
        myGI2.setVal("Hello");
        System.out.println(myGI2.getVal());
        System.out.println();



    }
    public  static <E> void printStuff(E[] arr)
    {   for (E x: arr) {  System.out.println(x);};  }

    public static void printAl (ArrayList<?> a) {
        for ( Object x: a) {
            System.out.println(x);
        }
    }
}

class MyGeneric <T> {
    T val;

    public void setVal (T val) {  this.val = val; }
    public T getVal () {   return val;  }
}
