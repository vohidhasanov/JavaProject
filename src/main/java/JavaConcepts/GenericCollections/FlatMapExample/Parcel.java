package JavaConcepts.GenericCollections.FlatMapExample;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Parcel {
    private String name;
    List<String> item;

    public Parcel(String name, String... item) {
        this.name = name;
        this.item = Arrays.asList(item);
    }

    public List<String> getItem() {
        return item;
    }

    public static void main(String[] args) {
        Parcel amazon = new Parcel("Amazon", "laptop", "phone");
        Parcel ebay = new Parcel ("Ebay", "mouse", "keyboard");
        List <Parcel> parcels = Arrays.asList(amazon, ebay);

        System.out.println("-------------- WtihOut flatMap-------------");
        List <List<String>> mapReturn = parcels.stream()
                .map(Parcel::getItem)
                .collect(Collectors.toList());
        System.out.println("\t collect() returns: "+ mapReturn);

        System.out.println("-------------- Wtih flatMap-------------");
        List<String> flatMapReturn = parcels.stream()
                .map(Parcel::getItem)
                .flatMap(Collection::stream)
                //.flatMap(Parcel->Parcel.stream())
                .collect(Collectors.toList());
        System.out.println("\t collect() returns"+flatMapReturn);

    }
}
