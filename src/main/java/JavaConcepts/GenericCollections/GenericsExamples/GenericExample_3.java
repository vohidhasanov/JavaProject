package JavaConcepts.GenericCollections.GenericsExamples;

public class GenericExample_3 <T extends Number> {
    T object;

    public GenericExample_3(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    void show () {
        double d = object.doubleValue();
        System.out.println(d);
    }

}
