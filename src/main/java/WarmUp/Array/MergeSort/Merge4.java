package WarmUp.Array.MergeSort;

import java.util.Arrays;

public class Merge4 {
static void mergeDivide(int array[], int low, int high) {
    if (low >= high) return;
    int middle = low+(high- low) / 2;
    mergeDivide(array, low, middle);
    mergeDivide(array, middle + 1, high);
    merge(array, low, middle, high);
}

static void merge(int array[], int low, int middle, int high) {
    int leftSize = middle - low+1;
    int rightSize = high - middle;

    int leftArray[] = new int[leftSize];
    int righArray[] = new int[rightSize];

    for (int i = 0; i < leftSize; i++) {
        leftArray[i] = array[low + i];
    }

    for (int i = 0; i < rightSize; i++) {
        righArray[i] = array[(middle + 1) + i];
    }

    int i = 0;
    int j = 0;
    int k = low;

    while (i < leftSize && j < rightSize) {
        if (leftArray[i] < righArray[j]) {
            array[k] = leftArray[i];
            k++;
            i++;
        } else {
            array[k] = righArray[j];
            k++;
            j++;
        }
    }

while (i<leftSize) {
    array[k] = leftArray[i];
    i++;
    k++;
}
while (j<rightSize) {
    array[k] =righArray[j];
    k++;
    j++;

}


    }



    public static void main(String[] args) {
    int array[] = {-7,5,-80,44,698,5,1,5000,-1557};
    mergeDivide(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
