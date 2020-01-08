package JavaConcepts.GenericCollections.GenericsParam;

import java.io.Serializable;

public class Gen3 <T extends Animal & Meeable & Serializable> {
    T object;

    public Gen3(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Gen3{" +
                "object=" + object +
                '}';
    }
}
