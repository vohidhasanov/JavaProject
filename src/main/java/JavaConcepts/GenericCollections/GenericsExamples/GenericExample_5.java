package JavaConcepts.GenericCollections.GenericsExamples;

import java.io.Serializable;

public class GenericExample_5<T extends Animal & Miewable & Serializable> {
    T object;

    public GenericExample_5(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    void show (){
        double d=object.doubleValue();
        System.out.println(d);
    }
}
