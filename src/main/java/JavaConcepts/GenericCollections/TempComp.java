package JavaConcepts.GenericCollections;

import java.util.Comparator;

public class TempComp implements Comparator <ComparatorExample>{
    @Override
            public int compare(ComparatorExample fruit1, ComparatorExample fruit2) {
            String fruitName1 = fruit1.getFruitName().toUpperCase();
            String fruitName2 = fruit2.getFruitName().toUpperCase();
            return fruitName1.compareTo(fruitName2);

    };
}
