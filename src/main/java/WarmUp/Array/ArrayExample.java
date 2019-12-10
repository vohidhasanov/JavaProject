package WarmUp.Array;

public class ArrayExample {
    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }
    }

    public void printArray() {
        System.out.println("----------");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("| "+ i+ " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    public int getValueAtIndex (int index) {
        if(index<arraySize) return theArray[index];
        return 0;
    }

    public boolean doesArrayContainValue(int searchValue) {
        boolean valueAnArray = false;
        for(int i=0; i<arraySize; i++) {
            if (theArray[i]==searchValue) {
                valueAnArray = true;
            }
          } return valueAnArray;
    }

    public void deleteIndex (int index) {
        if (index<arraySize) {
            for (int i = index; i<(arraySize-1); i++)
            {    theArray [i]= theArray[i+1];    }
            arraySize--;
        }
    }

    public void insertValue(int value) {
            theArray[arraySize]=value;
        arraySize++;
    }

    public String linearSearchForValue (int value) {
        boolean valueInArray = false;
        String indexWithValue = "";
        for (int x = 0; x < arraySize; x++) {
            if (theArray[x] == value) {
                valueInArray = true;
                System.out.print(x + " ");
                indexWithValue = +x + " ";
            }
            printHorizontalArray(x,-1);
        }

        if (!valueInArray) { System.out.println("None ");   }

        System.out.println("The value was found at index= " +indexWithValue);
        System.out.println();
        return indexWithValue;
    }

    public void bubbleSort() {
        for (int i= arraySize-1; i>1; i--) {
            for (int j=0; j<i; j++) {
                if(theArray[j] > theArray[j+1]) {
                     swapValues(j, j+1);
                     printHorizontalArray(i,j);
                }
            }
        }
    }

    public void swapValues(int index1, int index2) {
        int temp = theArray[index1];
        theArray[index1]=theArray[index2];
        theArray[index2]=temp;
     }

public void binarySearch(int value) {
        int lowIndex=0;
        int highIndex = arraySize-1;

        while(lowIndex<=highIndex) {
         int middleIndex =(highIndex+lowIndex)/2;
           if (theArray[middleIndex] < value)
              lowIndex=middleIndex+1;
                else if (theArray[middleIndex]>value)
                  highIndex = middleIndex-1;
                    else {
                     System.out.println("\n Found a Match for "+value+ " at index "+middleIndex);
                     lowIndex=highIndex+1;
                    }
            printHorizontalArray(middleIndex,-1);
        }
}

public void selectionSort() {
        for (int x=0; x<arraySize; x++) {
            int minimum = x;
            for (int y=x; y<arraySize; y++) {
                if (theArray[minimum]> theArray[y])
                { minimum = y;}
            }
            swapValues(x,minimum);
            printHorizontalArray(x,-1);
        }
}

public void insertionSort() {
        for (int i =1; i<arraySize; i++) {
            int j=i;
            int toInsert = theArray[i];

            while ((j>0) && (theArray[j-1]> toInsert)) {
                theArray[j] = theArray[j-1];
                j--;
                printHorizontalArray(i, j);
            }
            theArray[j] = toInsert;
            printHorizontalArray(i,j);
            System.out.println("\nArray[i]= "+theArray[i]
                    + " Array [j]= "+theArray[j]+ " toInsert="+toInsert);
        }
}



public void printHorizontalArray (int i, int j) {
    for (int n = 0; n < 51; n++) {
        System.out.print("-");
    }
    System.out.println();
    for (int n = 0; n < arraySize; n++) {
        System.out.print("| " + n + "  ");
    }
    System.out.println("|");

    for (int n = 0; n < 51; n++) System.out.print("-");
    System.out.println();

    for (int n = 0; n < arraySize; n++) {
        System.out.print("| " + theArray[n] + " ");
    }
    System.out.println("|");

    for (int n = 0; n < 51; n++) {
        System.out.print("-");
    }
    System.out.println();

if (j !=-1) {
    for(int k=0; k < ((j*5)+2); k++) System.out.print(" ");
    System.out.print(j);
}

    if (i != -1) //ADD -1 TO FIX SPACING
    {
        for (int l = 0; l < (5*(i-j)-1); l++)
            System.out.print(" ");
            System.out.print(i);

        System.out.println();
}

}

    public static void main (String[]args){
        ArrayExample newArray = new ArrayExample();
        newArray.generateRandomArray();
      //  newArray.printArray();
//        System.out.println(newArray.getValueAtIndex(2));
//        System.out.println(newArray.doesArrayContainValue(18));
//        newArray.deleteIndex(1);
////        newArray.printArray();
//        newArray.insertValue(15);
//        newArray.printArray();
       // newArray.bubbleSort();
        //newArray.binarySearch(11);
       // newArray.selectionSort();
        newArray.insertionSort();

    }
}