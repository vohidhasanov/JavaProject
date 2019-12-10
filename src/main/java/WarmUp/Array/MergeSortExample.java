package WarmUp.Array;

import java.util.Arrays;

public class MergeSortExample {
    public static void mergeSort(int array[], int lo, int n) {
        int low = lo;
        int high = n;

        if (low>=high) {
            return;}

        int middle =(low+high)/2;
        mergeSort(array, low, middle );
        mergeSort(array, middle+1, high);

        int end_low = middle;
        int start_high = middle+1;
        while ((lo <= end_low) && (start_high<=high))
        {
            System.out.println("\nBOTTOM ARRAY");
            printSmallArray(array, lo, middle);
            System.out.println("\nTOP ARRAY");
            printSmallArray(array, start_high, high);
            printHorizontArray(-1,-1,array, 49);
      // If the value in the 1st index of the fist array is less than the value int 1st
            // index of 2nd array
            System.out.println("Is "+array[low]+" < "+array[start_high]+"? "
                    + (array[low]<array[start_high]));

            if (array[low] < array[start_high]) {
                // Increment to the next index in the 1st array
                low++;
            } else {
                // Store the value in the 1st index of th 2nd array
                int Temp = array[start_high];
                System.out.println("Temp: "+Temp);

        // Decrement backwards through the first array starting at the index in the fist array
            for (int k =start_high-1; k>=low; k--) {
                System.out.println("array ["+ k + "] = "+array[k] + " Stored in array index "+(k+1));
                array [k+1] = array[k];
            }
            System.out.println(Temp + " is stored in index "+low);
            printHorizontArray(-1,-1,array, 49);
            array[low]= Temp;
            low++;
            end_low++;
            start_high++;

        }
        }
            printHorizontArray(-1,-1,array, 49);

    }


    public static void main(String[] args) {
        int array[] = { 10, 8, 4, 80, 13};
        System.out.println("STARTING ARRAY\n");
        printHorizontArray(-1,-1,array, 49);
        System.out.println();
       mergeSort(array, 0, array.length-1);
        System.out.println("FINAL SORTED ARRAY\n");
        printHorizontArray(-1,-1,array, 49);

    }

    static void printSmallArray (int[] theArray, int lo, int high) {
        int[] tempArray = Arrays.copyOfRange(theArray, lo, high);
        int tempArrayDashes = tempArray.length*6;
        System.out.println("Array Index start "+ lo + " and End "+ high );
        printHorizontArray(-1, -1, tempArray, tempArrayDashes);
    }


    static void printHorizontArray (int i, int j, int theArray[], int numDashes)
    {
        for (int x=0; x<numDashes; x++)
            System.out.print("-");
        System.out.println();

        for (int n=0; n<theArray.length; n++) {
            System.out.format("| %2s "+ " ", n);
        }

        System.out.println("|");

        for (int n=0; n<numDashes; n++)
            System.out.print("-");
        System.out.println();

        for (int n=0; n<theArray.length; n++) {
            System.out.print(String.format("| %2s "+ " ", theArray[n]));        }

        System.out.println("|");

        for (int n = 0; n<numDashes; n++)
            System.out.print("-");
            System.out.println();

    }
}
