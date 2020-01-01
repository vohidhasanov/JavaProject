package JavaConcepts.GenericCollections.GenericsExamples;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArrayDeclaration <E> {
    private E[] elements;

    public GenericArrayDeclaration(E[] elements) {
        this.elements = elements;
    }


    public GenericArrayDeclaration(Class <E> eClass, int size) {
       @SuppressWarnings("unchecked")
       final E[] a = (E[]) Array.newInstance(eClass, size);
        this.elements = a;
    }

    public void setElements(int index, E indexValue) {
        elements[index]=indexValue;
    }

    public E[] getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "GenericArrayDeclaration{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) {
        int size =10;
        Integer [] intArray = new Integer[10];
        GenericArrayDeclaration <Integer> arr = new GenericArrayDeclaration(Integer.class, size);
        GenericArrayDeclaration <String> str = new GenericArrayDeclaration(String.class, size);

        GenericArrayDeclaration <Integer> str1 = new GenericArrayDeclaration(intArray);

        for (int x=0; x<size; x++) {
            str1.setElements(x, x+10);
            arr.setElements(x, x+3);
            str.setElements(x, String.valueOf((char)(x+65)));

        }
        System.out.println((str1));
        System.out.println(arr);
        System.out.println(str);





    }
}
