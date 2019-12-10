package WarmUp.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void SelectionSort(int arr[]) {
        int arrayLengh = arr.length;

        for (int x = 0; x<arrayLengh-1; x++) {
            int min = x;

            for (int y = x+1; y<arrayLengh; y++) {
                if (arr[y]< arr[min]) {
                min = y;}
            }
            if (min != x) {
            int temp = arr[min];
            arr[min]=arr[x];
            arr[x] =temp;
        }
        }
        System.out.println(Arrays.toString (arr));
    }

    public static void main(String[] args) {
        int array [] = {10,2,-4,6,-77,100,-5000};

        SelectionSort(array);

     }
}
