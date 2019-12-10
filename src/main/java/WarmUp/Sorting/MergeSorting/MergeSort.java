package WarmUp.Sorting.MergeSorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergePartition(int array [], int left, int right) {
        if (left < right) {
            int middle = (left+right)/2;
            mergePartition(array, left, middle);
            mergePartition(array, middle+1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
      int tempArray [] = new int [array.length];


        int i = left;
        int j = middle+1;
        int k = left;

        while (i<= middle && j<= right)
        {
            if (array[i]<= array[j]) {
                tempArray[k] = array[i];
                i++;
                k++;

            }
            else {
                tempArray[k] =array[j];
                j++;
                k++;
                       }
        }

            while (i<=middle)
            {
                tempArray[k] = array[i];
                i++;
                k++;
            }

            while (j <= right) {
                tempArray[k] = array[j];
                j++;
                k++;
            }

        for (int x=left; x<=right; x++) {
            array[x] = tempArray[x];
        }


    }


    public static void main(String[] args) {
        int[] array = { 7, 6, 10, 5, 9, 20, 2, 1, 15,7 };
        mergePartition(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }

}
