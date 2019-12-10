package WarmUp.Array;

import java.util.Arrays;

public class Merge3 {
static void mergeSort(int[] array, int low, int high) {
    if (low >= high) {return;}
    int lo= low;
    int hi= high;
    int middle =(low+high)/2;

    mergeSort(array, lo, middle);
    mergeSort(array, middle+1, hi);
    int leftSize = middle;
    int rightSize = middle+1;
    int pointer=0;


    while(lo<=leftSize && rightSize<=hi) {
        if (array[lo] > array[rightSize]) {
           int temp = array[rightSize];
           // array[lo]=array[rightSize];

            for (int k= (rightSize)-1; k>=lo; k--){
                array[k+1]=array[k];}
                array[lo]=temp;
                lo++;
                rightSize++;
                leftSize++;
            } else
            lo++;
        }


  System.out.println(Arrays.toString(array));


}


    public static void main(String[] args) {
        int[] array = {10,5,55,-7,6,-10};
       mergeSort(array, 0, array.length-1);
    }
}
