package JavaConcepts.GenericCollections.GenericsExamples.Homework;

public class TestADD {
    public static int add (int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        TestADD t = new TestADD();
        System.out.println(t.add(2,2));

    }
}
