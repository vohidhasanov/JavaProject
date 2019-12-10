package WarmUp.Array;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class MergeMySort {
    public static void mergeSort(int[] array, int low, int high) {
        if (low>=high) {
            return;}
        int middle = (high+low)/2;
        int lowPoint = low;
        int highPoint = high;
        mergeSort(array, lowPoint, middle);
        mergeSort(array, middle+1, high);
        sortArray(array, lowPoint, middle, high);
    }

    public static void sortArray(int [] array, int lowestIndex, int middleIndex, int highestIndex) {
        int temp[] =new int[array.length];
        for (int y = 0; y<array.length; y++) {
        temp[y] = array[y]; }

        int leftPointer = lowestIndex;
        int rightPointer = middleIndex+1;
        int indexCounter = lowestIndex;
      //  int Temp=0;

        while ((leftPointer <= middleIndex && rightPointer <= highestIndex)) {

            if (temp[leftPointer] >= temp[rightPointer] )
            {
                array[indexCounter]= temp[rightPointer];
                rightPointer++;
            }else {
                array[indexCounter]= temp[leftPointer];
               leftPointer++;
            }
            indexCounter++;
        }
        while (leftPointer<=middleIndex) {
            array[indexCounter]=temp[leftPointer];
           // Temp=temp[leftPointer+1];
            indexCounter++;
            leftPointer++;
        }
    }

    public static void main(String[] args) {
        int [] array =  { 10, 8, 4, 80, 13, 1, 3, 11 };
        System.out.println("The array befor sorting: ");
        System.out.println(Arrays.toString(array));
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));

    }


}
