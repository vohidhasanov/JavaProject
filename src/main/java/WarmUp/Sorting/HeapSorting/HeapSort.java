package WarmUp.Sorting.HeapSorting;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort (int array [], int n) {
        for (int i = (n/2)-1; i>=0; i--) {
            maxHeapify(array, n, i);
         //   System.out.println(Arrays.toString(array));

        }
        for (int i = n-1; i>=0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i]=temp;
            maxHeapify(array, i, 0);
        }
    }

    public static void maxHeapify (int array [], int n, int i) {
        int largest = i;
        int left =2*i+1;
        int right = 2*i+2;

        while (left < n && array [left] > array[largest]) {
            largest = left;
        }
        while (right< n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i)
        {
            int temp = array[largest];
            array[largest] = array[i];
            array[i] = temp;
            maxHeapify(array, n, largest);
        //    System.out.println(Arrays.toString(array));
        }


    }
    public static void main(String[] args) {
        //int array [] = {15,5,20,1,17,10,30};
        int array [] = {7, 6, 10, 20, 5, 9, 2, 1, 15,7,-5000};
        heapSort(array, array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
