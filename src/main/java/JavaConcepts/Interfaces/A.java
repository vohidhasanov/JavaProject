package JavaConcepts.Interfaces;

import java.util.Comparator;

public class A <T> implements Comparator<T> {
    InterfaceTest animalsound;

  MyClass <T> func;

    public A(MyClass<T> func) {
        this.func = func;
    }

    public A(InterfaceTest animalsound) {
        this.animalsound = animalsound;
    }

    @Override
    public int compare(T t, T t1) {
        return func.testCompare(t).compareTo(func.testCompare(t1));
    }
}
