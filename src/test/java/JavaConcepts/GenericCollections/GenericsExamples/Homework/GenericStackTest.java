package JavaConcepts.GenericCollections.GenericsExamples.Homework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {
    GenericStack <String> stack;

@BeforeEach
void setUp () {
    stack = new  GenericStack  (3);
}

    @Test
    void push() throws StackException {
        stack.push("a1");
        stack.push("a2");
        stack.push("a3");

        assertEquals(3, stack.getSize());
        assertEquals("a3", stack.pop());
        assertEquals("a2", stack.pop());
        assertEquals("a1", stack.pop());
    }

    @Test
    void pop() throws StackException {
        System.out.println(stack.pop());
    }

    @Test
    void peek() {
    }

    @Test
    void getSize() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void isFull() {
    }

    @Test
    void pushAll() {
    }

    @Test
    void popAll() {
    }
}