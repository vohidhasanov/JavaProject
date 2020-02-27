package Maps;

import java.util.HashMap;
import java.util.Map;

public class MapEx1 {

    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);

        for (Map.Entry <String, Integer> myList : items.entrySet()) {
            System.out.println("Item: "+ myList.getKey()+ " Number: "+ myList.getValue());
        }

        items.forEach((k,v)->System.out.println("Item "+k+ " Count "+ v));

        items.forEach((k,v) -> {
            System.out.println("Item: "+ k+ " Count: "+v);
            if ("E".equals(k)) System.out.println("Hello E");
        });

    }

}
