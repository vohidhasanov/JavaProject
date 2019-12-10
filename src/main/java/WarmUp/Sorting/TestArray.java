package WarmUp.Sorting;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Arrays;

public class TestArray {

    public static void insertionSort(int[] array) {
        int arraySize = array.length;
        int temp;
        int leftPointer=0;

        for (int x=1; x<arraySize; x++)
        {
            temp = array[x];
            leftPointer = x-1;
         while (leftPointer >= 0 && array[leftPointer]>temp)
            {
                array[leftPointer+1] = array[leftPointer];
                leftPointer--;
            }
            array[leftPointer+1] = temp;

        }
        System.out.println(Arrays.toString(array));

    }

    public static void insertionSort2 (int [] array) {
        int temp;
        int pointer = 0;
        int arraySize = array.length - 1;
        int temp2 = 0;

        for (int index = (array.length-1);
             index >= 0 ;
             index--) {
            pointer =index-1;
            temp = array[index];

            while (pointer>=0 && array[pointer]> temp) {
        temp2 = array[pointer];
        array[pointer+1] = temp2;
        array[pointer] = temp;
        pointer--;
    }
//array[pointer+1]=temp;
        }


        System.out.println(Arrays.toString(array));
    } // Хатолик бор

    public static void insertionSort3 (int [] array) {
        int temp=0;
        int pointer = 0;
        int arraySize = array.length - 1;

        for (int index = arraySize; index >= 0 ; index--) {
            if (index>0)
            {    pointer = arraySize;     }

            while (pointer>0  )
            {  int val=pointer;

                while (val>0 && array[val]<array[val-1])
                {
                    temp = array[val - 1];
                    array[val - 1] = array[val];
                    array[val] = temp;
                    val--;
                    pointer--;
                }
                pointer--;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,0};
        int temp [] = new int[array.length];
        int tempPointer=0;
        int tempNumber=0;

        insertionSort(array);
      //  insertionSort2(array);
      //  insertionSort3(array);









    }
}
