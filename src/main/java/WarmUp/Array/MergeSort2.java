package WarmUp.Array;

import java.util.Arrays;

public class MergeSort2 {
 static void mergeSort (int array[], int lo, int hi) {

     int low = lo;
     int high = hi;
     if (low >= high) {   return;  }
     System.out.println("My index of low is " + low + " and my index of high is " + high);
    //
     int middle = (low + high) / 2;

     mergeSort(array, low, middle);
   //  System.out.println("After -My index of low is " + low + " and my index of high is " + high);
     mergeSort(array, middle + 1, high);
     System.out.println("After -My index of low is " + low + " and my index of high is " + high);
     System.out.println(Arrays.toString(array));
    int leftEnd = middle;
    int rightFirst = middle+1;


    while ( low<=leftEnd && rightFirst <= high)
    {
        if (array[low] > array[rightFirst]) {
            int temp= array[rightFirst];


            for (int k= rightFirst-1; k>=low; k-- ) {
                array[k+1]= array[k]; }

               array[low]=temp;
                low++;
                rightFirst++;
                leftEnd++;



        } else low++;

    }
     System.out.println(Arrays.toString(array));
 }

    public static void main(String[] args) {
        int array[] = {10, 8, 4, 80, 13, 1, 3, 11};
        mergeSort(array, 0, array.length-1);
    }


}
