package JavaConcepts.GenericCollections;

import javax.imageio.stream.ImageInputStream;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Number> stack = new Stack<>();
        stack.push(12L);
        stack.push(34567);
        printStack(stack);
        stack.push(1.0F);
        printStack(stack);
        stack.push(1234.5678);
        printStack(stack);


        //remove items
        try {
            Number removedObject = null;
            while (true) {
                removedObject = stack.pop();
                System.out.printf("Popped %s%n", removedObject);
                printStack(stack);
            }
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

    }

    private static void printStack(Stack<Number> stack) {
        if (stack.isEmpty()) {
            System.out.printf("stack is empty%n%n");
        } else System.out.printf("stack contains: %s (top)%n", stack);
    }
}

