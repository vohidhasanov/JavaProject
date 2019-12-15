package JavaConcepts.GenericCollections.ComparatorExamplePackage;

import java.util.Comparator;

abstract class CompareFunction <A> {
abstract public Comparable apply (A object);
//abstract public Comparator applyComparator(A object);
}


