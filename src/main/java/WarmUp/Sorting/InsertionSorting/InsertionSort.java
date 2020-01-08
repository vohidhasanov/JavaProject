package WarmUp.Sorting.InsertionSorting;

import java.util.Arrays;

public class InsertionSort {

    public static void  insertSort (int [] arr) {
        for (int x =0; x<arr.length; x++) {
            int j = x;
            int insert = arr[j] ;

            while (j>0 && arr[j-1]> insert) {
                arr[j] = arr[j-1];
                j--;
            }
        arr[j] = insert;
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] array = {10,5,-7,4,7,100,0};

        InsertionSort.insertSort(array);

    }
}
