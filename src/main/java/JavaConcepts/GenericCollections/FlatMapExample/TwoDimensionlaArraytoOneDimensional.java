package JavaConcepts.GenericCollections.FlatMapExample;

import java.util.Arrays;

public class TwoDimensionlaArraytoOneDimensional {

    public static void main(String[] args) {
        int [][] arr = {{1,2} ,
                        {3,4},
                        {5,6},
                        {7,8}};

       // System.out.printf(Arrays.toString(arr));
//        for (int x=0; x< arr.length; x++) {
//            for(int y=0; y<arr[x].length; y++) {
//                System.out.print(arr[x][y]+" ");
//            }
//            System.out.println();
//        }
        int [] arr1 = new int[arr.length*arr[0].length];
        System.out.println(arr.length);
        System.out.println(arr[2].length);

        arr1 = Arrays.stream(arr)
                .flatMapToInt(a-> Arrays.stream(a))
                .toArray();

        System.out.println(Arrays.toString(arr1));
    }
}
