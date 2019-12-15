package JavaConcepts.GenericCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.AbstractCollection;

public class AbstractCollectionExample {

    public static void main(String[] args) {
        AbstractCollection<String> abs1 = new TreeSet<String>();
      //  List<String> abs1 = new ArrayList<>();

        abs1.add("Welcome");
        abs1.add("To");
        abs1.add("Geeks");
        abs1.add("4");
        abs1.add("Geeks");
        abs1.add("TreeSet");

        System.out.println("AbstactCollection 1: "+abs1);

        AbstractCollection <String> abs2 = new TreeSet<>();
        System.out.println("AbstractCollection 2: "+ abs2);

        abs2.addAll(abs1);

        System.out.println("After addALL method AbstractCollection 2: "+ abs2);



    }
}
