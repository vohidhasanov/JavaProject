package WarmUp.Sorting;

import java.util.Arrays;

public class BubbleSort {

    static void bubleSort(int arr[])
    { int arraySize = arr.length;

    for (int x=0; x<arraySize-1; x++) {
        int flag=0;
        for (int y = 0; y<arraySize-1-x; y++) {
            if (arr[y] > arr[y+1]) {
                int temp = arr[y+1];
                arr[y+1] = arr[y];
                arr[y] = temp;
                flag=1;
            }
        }
        if (flag==0) break;
    }
        System.out.println("Array sorted: "+ Arrays.toString(arr));

    }

    public static void main(String[] args) {

        int array [] ={5000,10,1,-7,9,54,6,-100,-500,6,11};
        bubleSort(array);

    }
}
