package Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestMap {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List <List<Integer>> listOfLists = Arrays.asList(list1, list2,list3);
        System.out.println(listOfLists.get(0).get(2));
//        for (int x = 0; x< listOfLists.size(); x++) {
//            System.out.print("[");
//            for (int y=0; y< listOfLists.get(x).size(); y++) {
//                if (y==listOfLists.get(x).size()-1) {
//                    System.out.print(listOfLists.get(x).get(y)*2 + "");
//                } else {
//                    System.out.print(listOfLists.get(x).get(y)*2+" ");
//                }
//            }
//            System.out.print("]");
//            if (x==listOfLists.size()-1)
//                break;
//            System.out.print(", ");
//        }
//        System.out.println();
      // List <List<Integer>> tripleList = listOfLists.stream().forEach(x);
        Consumer<Integer> consumer = s -> System.out.println(s);
        consumer.accept(10);

        Consumer<List<Integer>> modify = list -> {
            for(int x=0; x<list.size(); x++) {
                list.set(x, 2*list.get(x));
            }
        };

        Consumer <List<Integer>> displayList =  list -> list.stream().forEach(a-> System.out.print(a+ " "));
        List <Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

    //    modify.accept(list);
    //    displayList.accept(list);
        // same as above but using andThen
     //   modify.andThen(displayList).accept(list);
    try {
        displayList.andThen(modify).accept(list);
        ;
    } catch (Exception e) {
        System.out.println("Exception "+ e);
        }

        //System.out.println(tripleList);

//        List<Integer> doubledList = listOfLists.stream().flatMap(s->s.stream()).map(s->s*2).collect(Collectors.toList()) ;
//        System.out.println(doubledList);
    }

}
