package WarmUp.Array;

import java.util.Arrays;

public class InsertionSortTest {
    public static void insertionSortTest(int [] arr) {
        int arrlength= arr.length;
        for (int x =1; x<arr.length; x++) {
            int y=x;
            int insertionValue =arr[x];

            while(y>0 && arr[y-1] > insertionValue) {
                arr[y] = arr[y-1];
                y--;
            }

            arr[y]=insertionValue;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int [] arr = {11,16,17,19,10,15,13,18,8,1};
        insertionSortTest(arr);

    }
}
