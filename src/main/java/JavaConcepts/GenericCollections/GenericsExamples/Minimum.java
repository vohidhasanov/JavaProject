package JavaConcepts.GenericCollections.GenericsExamples;

public interface Minimum <T extends Comparable <T>> {
    T min();
}
