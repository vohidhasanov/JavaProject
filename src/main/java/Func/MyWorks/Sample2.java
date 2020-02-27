package Func.MyWorks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static javax.swing.UIManager.put;

public class Sample2 {

    public static void main(String[] args) {
        Map <String, Integer> iqMap = new ConcurrentHashMap<String, Integer> () {{
            put("Larry", 100); put("Curly", 90); put("Moe", 110);
        }};
        System.out.println(iqMap);

        iqMap.entrySet().removeIf(entry -> entry.getValue() <=100);
        System.out.println(iqMap);

    }
}