package WarmUp.Sorting.QuickSorting;

import java.util.Arrays;

public class QuickSort4 {


    public static void main(String[] args) {

        int array [] = {7, 6, 10, 20, 5, 9, 2, 1, 15,7};

        quicksort4 (array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quicksort4(int[] array, int low, int high) {

        if (low < high) {
            int loc = partition(array, low, high);
            quicksort4(array, low, loc-1);
            quicksort4(array, loc+1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low-1;

        for (int j = low; j<high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j]=temp;
            }
        }
        int temp = array[high];
        array[high] = array[i+1];
        array[i+1] = temp;

        return i+1;
    }


}
