package JavaConcepts.Interfaces;

import java.util.Comparator;

public class TestClass <T> implements Comparator<T> {
    TestInterface <T> testInterface;

    public TestClass(TestInterface <T> testInterface) {
        this.testInterface = testInterface;
    }


    @Override
    public int compare(T t, T t1) {
        return testInterface.test(t).compareTo(testInterface.test(t1));
    }
}
