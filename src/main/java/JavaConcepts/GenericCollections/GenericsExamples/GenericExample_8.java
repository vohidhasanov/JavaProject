package JavaConcepts.GenericCollections.GenericsExamples;

public class GenericExample_8 <T extends Comparable<T>> implements Minimum <T> {
    T[] objects;

    public GenericExample_8(T[] objects) {
        this.objects = objects;
    }


    @Override
    public T min() {
       if (objects==null || objects.length<0) {return null;}
        T m = objects[0];
        for (T object : objects) {
            if (object.compareTo(m)<0) {
                m=object;
            }
        }

        return m;
    }
}
