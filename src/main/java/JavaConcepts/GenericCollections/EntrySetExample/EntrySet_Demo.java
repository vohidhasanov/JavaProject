package JavaConcepts.GenericCollections.EntrySetExample;

import java.security.KeyStore;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EntrySet_Demo {

    public static <K, V> void main(String[] args) {
     Map<String, Long> map1 = new TreeMap<>();
     map1.put("Geeks", 10l);
     map1.put("Brando", 15l);
     map1.put("Geeks", 20l);
     map1.put("Welcomes", 25l);
     map1.put("YOu", 30l);
     map1.put("Arturddddd", 10l);

     List keyList = new ArrayList(map1.keySet());
     List valueList = new ArrayList (map1.values());
     List entryList = new ArrayList (map1.entrySet());


//     for (Map.Entry entry: map1.entrySet()) {
//         K key = (K) entry.getKey();
//         String character = String.valueOf(((String)key).charAt(1)).toUpperCase();
//         System.out.println(character);
//
//          V value = (V) entry.getValue();
//
//         System.out.println(key+" - "+value);
//
//     }

     Pattern pattern = Pattern.compile("\\s");
    Map<String, Long> map2 =
            map1.entrySet().stream().
                    map(line-> line.getKey().split(""))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));





     Iterator itr = map2.entrySet().iterator();   /// Old version of Iteration
     while (itr.hasNext()) {
         Map.Entry entry = (Map.Entry) itr.next();
         K key = (K) entry.getKey();
         V value = (V) entry.getValue();

         System.out.print(map2.get(key)+" ");
         System.out.println(key);
     }


//        System.out.println("the key list is: "+ keyList);
//        System.out.println("the value list is: "+ valueList);
//        System.out.println("the key-value list is: "+entryList);
//
//
//
//        System.out.println("Initial Mapping are: "+ map1);
//        System.out.println("The set is (entrySet): "+map1.entrySet());


    }


}
