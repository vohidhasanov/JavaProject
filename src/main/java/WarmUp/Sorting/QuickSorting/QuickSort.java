package WarmUp.Sorting.QuickSorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void QuickSort(int arr[], int low, int high) {


        if (low < high) {

            int loc = Partion1 (arr, low, high);
            QuickSort(arr, low, loc);
            QuickSort(arr, loc+1, high);
    }
        System.out.println(Arrays.toString (arr));
    }

    private static int Partion1(int[] arr, int low, int high) {

        int pivot = arr[low];
        int start = low;
        int end = high;


        while (start <= end)
        {
                    while (arr[start] < pivot  )  //&& start < end
            {
                start++;
            }

            while (arr[end] > pivot )
            {
                end--;
            }

        if (start <= end)
        {
           int temp = arr[end];
            arr [end] = arr [start];
            arr[start] = temp;
            start++;
            end--;
        }
   }
        int temp = arr[low];
        arr[low] = arr[end];
        arr[end] = temp;

        return end;
    }

    private static int Partion2 (int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int pivotIndex = low;
        for (int i = low; i<high; i++)
        {
            if (arr[i] < pivotValue) {
                int temp = arr[pivotIndex];
                arr[pivotIndex] = arr[i];
                arr[i] = temp;
                 pivotIndex++;
            }
        }
        int temp = arr[high];
        arr[high]=arr[pivotIndex];
        arr[pivotIndex]=temp;
        return pivotIndex;
    }

    private static int Partion3 (int[] arr, int low, int high) {
        int pointer=0;
        int pivotValue = arr[high];
        int pivotIndex = high;
        for (int i = high; i>low; i--)
        {
            if (arr[i] < pivotValue) {
                int temp = arr[pivotIndex];
                arr[pivotIndex-1] = arr[i];
                arr[i] = temp;
                pivotIndex--;
            }
            pivotIndex--;
        }
        int temp = arr[low];
        arr[low]=arr[pivotIndex];
        arr[pivotIndex]=temp;
        return pivotIndex;
    }

    public static void main(String[] args) {

        int array [] = {7, 6, 10, 20, 5, 9, 2, 1, 15,7,-5000};

         QuickSort(array, 0, array.length-1);
     //   System.out.println(Arrays.toString (array));

     }
}
