package JavaConcepts.GenericCollections.GenericsExamples;

import java.io.Serializable;

public class GenericExample_4 <T extends Animal > {
    T object;

    public GenericExample_4(T object) {
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
