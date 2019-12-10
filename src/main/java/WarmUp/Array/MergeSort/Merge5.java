package WarmUp.Array.MergeSort;

import java.util.Arrays;

import static java.util.Arrays.parallelSetAll;
import static java.util.Arrays.sort;

public class Merge5 {


    public static void main(String[] args) {

        int array[] = {10, 8, 4, 80, 13, 1, 3, -11};
        int array3[] ={1,5,6,99,-100,-44,200};


        System.out.println();
        mergeDivide(array, 0, array.length-1);

        //int size= array.length;
        int arraySize = array.length - 1;
        int temp = 0;
        int pointer = 0;
        int min=0;
        int array2[] = new int[arraySize];
        int k=0;


//       while (pointer<arraySize) {
//
//           for (int z = pointer; z <= arraySize; z++) {
//            if (array[pointer]> array[z]) {
//               temp = array[z];
//               array[z] = array[pointer];
//               array[pointer]=temp;
//            }
//          }
//
//           pointer++;
//               }
//        System.out.println(Arrays.toString(array));
//
//
//
           }

           static void  mergeDivide(int arr[], int low, int high) {
        if (low>=high) return;
        int middle = (low+high)/2;

            mergeDivide(arr, low, middle);
            mergeDivide(arr, middle+1, high);
            mergeSort(arr, low, high);

           }

           static void mergeSort(int array[], int left, int right) {
                int tempArray[] =new int[array.length];
                for (int x=0; x<tempArray.length; x++) {
                    tempArray[x] = array[x];
                }
               int middle = (left + right) / 2;
               int pointer = left;
               int leftsize = left;
               int leftMargin = middle;
               int rightsize = middle + 1;
               int temp = 0;


               while (leftsize<= leftMargin && rightsize<=right) {
                   if (tempArray[leftsize] >= tempArray[rightsize])
                   {   array[pointer] = tempArray[rightsize];
                       pointer++;
                       rightsize++;
                   } else
                       {array[pointer] = tempArray[leftsize];
                   pointer++;
                   leftsize++;}
               }
                while (leftsize<= leftMargin) {
                    array[pointer] = tempArray[leftsize];
                    pointer++;
                    leftsize++;
                }

//               while (leftsize <= leftMargin && (rightsize) <= right) {
//                   if (array[leftsize] > array[rightsize]) {
//                       temp = array[rightsize];
//
//                       for (int k = rightsize - 1; k >= leftsize; k--)
//                       {
//                           array[k + 1] = array[k];
//                       }
//                       array[leftsize] = temp;
//                       leftsize++;
//                       rightsize++;
//                       leftMargin++;
//                   }
//                   else leftsize++;
//               }

               System.out.println(Arrays.toString(array));
            }




           }





