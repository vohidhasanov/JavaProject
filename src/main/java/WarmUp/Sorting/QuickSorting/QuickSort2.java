package WarmUp.Sorting.QuickSorting;


import java.util.Arrays;

public class QuickSort2 {

    public static void QuickSrort2 (int [] arr, int low , int high) {
        int start = low;
        int end = high;
        int pivot = arr[(low+high)/2];

        do  {
            while (arr[start]<pivot )
                start++;
            while (arr[end]> pivot)
                end--;
            if (start<= end )
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        } while (start<=end);

        if (low < end) QuickSrort2(arr, low, end);
        if (start < high) QuickSrort2(arr, start, high);

      //  System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int array [] = {7, 6, 10, 20, 5, 9, 2, 1, 15,7};

        QuickSrort2(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }
}
