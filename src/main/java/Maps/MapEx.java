package Maps;

import java.util.HashMap;
import java.util.Map;

public class MapEx {

    public static void main(String[] args) {
        Map<Object, String> mp = new HashMap<>();
        mp.put(new Integer(1), "one");
        mp.put(new Integer(2), "two");

        Map <Object, String> mp1 = new HashMap<>();
        mp1.put(3, "three");
        mp1.put(4, "four");

        Map <Object, Object> mpMaps = new HashMap<>();
        mpMaps.put("map1", mp);
        mpMaps.put("map2", mp1);

        Map <Object, Map<Object, String>> mpMap2 = new HashMap<>();
        mpMap2.put("1", mp);
        mpMap2.put("2", mp1);


        System.out.println("This is a map of maps: "+ mpMap2);

//        for(Map.Entry set: mpMaps.entrySet()) {
//            System.out.println(set.getKey()+ " "+set.getValue());
//        }




    }


}
