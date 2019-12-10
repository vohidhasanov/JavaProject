package WarmUp.Sorting.QuickSorting;

import java.util.Arrays;

public class QuickSort5 {

    public static void main(String[] args) {

        int array [] = {7, 6, 10, 20, 5, 9, 2, 1, 15,7};

        quicksort5 (array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void quicksort5(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = array[(left+right)/2];
        int index = partition (array, left, right, pivot);
        quicksort5(array, left, index-1);
        quicksort5(array, index, right);

    }

    private static int partition(int[] array, int left, int right, int pivot) {

        while (left<=right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }
           if (left <= right)
           {
               int temp = array[right];
               array[right] = array[left];
               array[left]=temp;
               left++;
               right--;
           }

        }
        return left;
    }
}
