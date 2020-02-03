package Problems;

public class Queens {
    final int N=4;

    // print a solution

    void printSolution(int board [][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j<N; j++) {
                System.out.print(" "+ board[i][j]+ " ");
            }
            System.out.println();
        }
    }

 /* A utility function to check if a queen can be placed on
 board [row] [col]. Note that this function is called when
 "col" queens are already placed in columns from 0 to col-1
 So we need to check only left side for attacking queens*/

 boolean isSafe (int board [][], int row, int col) {
     int i, j;

     // check this row on the left side
     for ( i=0; i < col; i++) {
        if (board[row][i] == 1)
            return false;

     }
    //check upper diagonal diagonal on left side
     for (i = row, j = col; i >=0 && j >=0; i--, j--) {
         if (board[i][j] == 1)
             return false;
     }


     //check lower diagonal on left side
     for (i=row, j=col; j>=0 && i<N; i++, j--) {
         if (board[i][j] == 1)
             return false;
     }
     return true;
 }

 /* A reucrsive utitlity to solve N queen problem  */
    boolean solveNQUtil (int board[][], int col) {
        // base case if all queens are placed then return true
        if (col>=N) return true;

        //Consider this column and try placing this queen in all rows one by one
        for (int i= 0; i <N; i ++) {
            //check if the queen canbe palced on board [i][col]
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                //recur to place rest of the queens
                if (solveNQUtil(board, col+1))
                    return true;

                // if placing queen in board[i][col] doesn't lead to solution
                    //then remove queen from board[i][col]
                board[i][col] = 0;
            }
        }
        return false;
    }
    boolean solveNQ() {
        int board [][] = {  {0,0,0,0},
                            {0,0,0,0},
                            {0,0,0,0},
                            {0,0,0,0},   };

        if (solveNQUtil(board, 0) == false) {
            System.out.println("Solution doesn't exists");

        }
        printSolution(board);
        return true;
    }




    public static void main(String[] args) {
        new Queens().solveNQ();
    }

}
