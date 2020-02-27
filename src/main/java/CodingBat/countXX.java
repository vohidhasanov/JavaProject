package CodingBat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class countXX {

    static int countXX (String str) {
        int count=0;
        for (int x=0; x < str.length()-1; x++) {
                if ((str.charAt(x)=='x') && (str.charAt(x+1)=='x')) {
                count++;
            }
        } return count;
    }
    static List<Integer> doubling (List <Integer> nums) {
        List <Integer> numsToDouble = nums.stream().map(x->x*2).collect(Collectors.toList());
        return numsToDouble;
    }

    public static void main(String[] args) {
        System.out.println(countXX ("xxxx"));
        System.out.println(doubling(List.of(2,4,6,8,10)));

    }

}
