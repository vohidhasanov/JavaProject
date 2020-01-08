package General;

import java.util.Stack;

public class TOH {

    class Stack
    {
        int capacity;
        int top;
        int[] array;
    }
        Stack createStack (int capacity) {
            Stack stack = new Stack();
            stack.capacity=capacity;
            stack.top=-1;
            stack.array=new int[capacity];
            return stack;
        }

        //Stack is full when the top is equal to the last index
        boolean isFull (Stack stack) {
            return (stack.top == stack.capacity-1);
        }

        //Stack is empty when the top is equal to -1
        boolean isEmpty (Stack stack) {
            return (stack.top == -1);
        }

        //Function to add an item to the stack. It increases top by 1
        void push (Stack stack, int item) {
            if (isFull(stack))
                return;
            stack.array[++stack.top]=item;
        }

        // Function to remove an item from the stack. It decreases top by 1
        int pop (Stack stack) {
            if (isEmpty(stack))
                return Integer.MIN_VALUE;
            return stack.array[stack.top--];
        }

        //Function to implement legal movement between two poles
        void moveDisksBetweenTwoPolews (Stack src, Stack dest, char s, char d) {
            int pole1TopDisk = pop(src);
            int pole2TopDisk = pop (dest);

            //when pole 1 is empty
            if (pole1TopDisk == Integer.MIN_VALUE) {
                push(src, pole2TopDisk);
                moveDisk(d,s,pole2TopDisk);
            }

            //when pole 2 is empty
            else if (pole2TopDisk == Integer.MIN_VALUE) {
                push(dest, pole1TopDisk);
                moveDisk(s,d,pole1TopDisk);
            }
            //When top disk of pole1 > pole2
            else if (pole1TopDisk > pole2TopDisk) {
                push (src, pole1TopDisk);
                push (src, pole2TopDisk);
                moveDisk(d,s,pole2TopDisk);
            }
            //When top disk of Pole 1 < top disk of Pole 2
            else {
                push(dest, pole2TopDisk);
                push(dest, pole1TopDisk);
                moveDisk(s,d, pole1TopDisk);
            }
        }
    // Fuction to show the movement of the disks
        void moveDisk (char fromPeg, char toPeg, int disk) {
            System.out.println("Move the disk "+ disk+ " from "+fromPeg+" to "+toPeg);
        }

        //Fuction to implement the POH puzzle
        void tohIterative (int num_of_disks, Stack src, Stack aux, Stack dest) {

            int i, total_number_of_moves;
            char s='S', d='D', a='A';
            //If number of disks is even then interchange destination pole and auxilarity pole
            if (num_of_disks%2==0) {
                char temp =d;
                d=a;
                a=temp;
            }
            total_number_of_moves = (int)(Math.pow(2, num_of_disks)-1);

            //Larger disks will be pushed first
            for (i = num_of_disks; i>=1; i-- ) {
                push (src, i);
            }

            for (i=1; i <=total_number_of_moves; i++)
            {
                if (i % 3== 1) moveDisksBetweenTwoPolews(src, dest,s,d);
                if (i % 3 == 2) moveDisksBetweenTwoPolews(src,aux, s, a);
                if (i % 3 == 0) moveDisksBetweenTwoPolews(aux, dest, a, d);
            }




        }

    public static void main(String[] args) {
        int numberOfDisks = 3;

        TOH ob = new TOH();
        Stack src, dest, aux;

        src = ob.createStack(numberOfDisks);
        dest = ob.createStack(numberOfDisks);
        aux = ob.createStack(numberOfDisks);

        ob.tohIterative(numberOfDisks, src, aux, dest);
    }

}
