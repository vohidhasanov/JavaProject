package WarmUp.Sorting.ShellSorting;


import java.util.Arrays;

public class ShellSort {

    public static void shellSort (int[] arr) {
        int temp, inner, outer;
        int interval = arr.length / 2;

//        while (interval <= arr.length / 2) {
//            //  while (interval > 0) {
//            interval = (interval * 2) + 1;
//        }

        while (interval > 0)
        {
            for (outer = interval; outer < arr.length; outer++)
            {
                temp = arr[outer];
                inner = outer;
              while (inner > interval-1 && arr[inner - interval] >= temp) //while (inner > interval - 1 && arr[inner - interval] >= temp)
                {
                    arr[inner] = arr[inner - interval];
                    inner -= interval;
                }
                arr[inner] = temp;
            }
            interval = (interval - 1) / 2;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort2 ( int [] arr) {
        int gap;
        for ( gap=arr.length/2; gap>=1;
              gap= gap/2) {
            for (int j = gap; j<arr.length;
                 j++) {
                for (int i = j-gap; i>=0;
                     i=i-gap) {
                    if (arr[i+gap] > arr[i])
                        break;
                    else
                    {
                        int temp = arr[i];
                        arr[i] = arr[i+gap];
                        arr[i+gap]=temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] array = {10,5,-7,4,7,100,0}; //{10,5,-7,4,7,100,0}
        shellSort(array);
      //  shellSort2(array);
    }
}
