package JavaConcepts.GenericCollections.GenericsExamples;

public class GenericExample_7 {
    int i;

    // обобщенный конструктор в необобщенном классе
    public <T extends Number> GenericExample_7(T i) {
        this.i = i.intValue();
    }

    public static void main(String[] args) {
        show1 (new Animal(), 12);
    }



    private static <T extends Animal,  V extends Number> void show1(T o, V i) {
        System.out.println(o.doubleValue()+" "+i);
    }

}
