package JavaConcepts.GenericCollections.GenericsExamples;

public class GenericExample_2 <K, V> {
    K object;
    V object2;

    public GenericExample_2(K object, V object2) {
        this.object = object;
        this.object2 = object2;
    }

    public K getObject() {
        return object;
    }

    public void setObject(K object) {
        this.object = object;
    }

    public V getObject2() {
        return object2;
    }

    public void setObject2(V object2) {
        this.object2 = object2;
    }

    @Override
    public String toString() {
        return "GenericExample_2{" +
                "object=" + object +
                ", object2=" + object2 +
                '}';
    }
}
