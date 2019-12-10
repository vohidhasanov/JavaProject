package WarmUp.Sorting.QuickSorting;

import java.util.Arrays;

public class QuickSort1 {

        public static void main(String[] args) {
            int[] x = { 7, 6, 10, 5, 9, 20, 2, 1, 15,7 };
            System.out.println(Arrays.toString(x));

            int low = 0;
            int high = x.length - 1;

            quickSort(x, low, high);
            System.out.println(Arrays.toString(x));
        }

        public static void quickSort(int[] arr, int low, int high) {
            if (arr == null || arr.length == 0)
                return;

            if (low >= high)
                return;

            // pick the pivot
            int middle = low + (high - low) / 2;
            int pivot = arr[low];

            // make left < pivot and right > pivot
            int i = low, j = high;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }

                while (arr[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                }
            }

            // recursively sort two sub parts
            if (low < j)
                quickSort(arr, low, j);

            if (high > i)
                quickSort(arr, i, high);
        }

}
