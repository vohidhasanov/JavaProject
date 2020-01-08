package JavaConcepts.GenericCollections.GenericMap;



import java.util.*;

public class GenMap {

static void Gen1 (List<Map<String,String>> example) {}
static void Gen2 (List<? extends Map<String, String>> example2) {}

     public static void main(String[] args) {
    List <TreeMap<String, String>> hashMap1 = new ArrayList<>();

   Gen2(hashMap1);
  // Gen1(hashMap1);
        Map <String, String> aMap= Collections.singletonMap("key", "value");
         System.out.println(aMap);

         hashMap1.add((TreeMap<String, String>) aMap);
         Gen1((List<Map<String, String>>) aMap);

         Gen2((List<? extends Map<String, String>>) aMap);




    }
}
