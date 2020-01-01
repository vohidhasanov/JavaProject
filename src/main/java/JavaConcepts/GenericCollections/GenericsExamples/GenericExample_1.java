package JavaConcepts.GenericCollections.GenericsExamples;

public class GenericExample_1 <T> {
    T object;

    public GenericExample_1(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
