package JavaConcepts.GenericCollections.GenericsExamples;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericArrayWithObjecDeclaration <E> {
    private Object[] elements;
    public final int length;

    public GenericArrayWithObjecDeclaration(int length) {
        elements = new Object[length];
        this.length = length;
    }

    E get (int i) {
        @SuppressWarnings("unchecked")
        final E e = (E) elements[i];
        return e;
    }

    void setElements (int index, E values) {
        elements[index]=values;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
        GenericArrayWithObjecDeclaration <Integer> arrInt = new GenericArrayWithObjecDeclaration<>(10);
        GenericArrayWithObjecDeclaration <String> arrStr = new GenericArrayWithObjecDeclaration<>(10);


        for (int x =0; x< arrInt.length; x++) {
            arrInt.setElements(x, x+2);
            arrStr.setElements(x, String.valueOf((char)(x+75)));
        }
        System.out.println(arrInt);
        System.out.println(arrStr);
        System.out.println(arrInt.get(5));


        List<String> str = new ArrayList<>();
        //List<Object> obj = str;
        List raw =str;

    }
}
