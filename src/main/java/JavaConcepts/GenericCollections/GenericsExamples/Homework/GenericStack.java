package JavaConcepts.GenericCollections.GenericsExamples.Homework;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.util.*;



public class GenericStack <E> implements Stack <E>{
    Logger logger = Logger.getLogger(GenericStack.class);
   public final int size;
   private E[] elements;
   private int filledNumberOfIndexes;
   private int numberOfEmptyIndexes;
   private int lastFilledIndex;
   private int x;
   private int index;



    public GenericStack(int size) {
        this.size = size;
       // elements = (E[]) java.lang.reflect.Array.newInstance(type);
        elements = (E[]) new Object[size];
    }




    @Override
    public void push(E element) throws StackException {
        try {
            if (isFull()) throw new StackException("Stack overloaded") ;
        } catch (Exception e) {
            e.printStackTrace();
        }

      //  if (!isFull() )     //&& x <elements.length
      //  {
        elements [x++]=element;
        logger.info ("String pushed to stack "+elements[x-1]);

     //   }
        lastFilledIndex=x-1;
        numberOfEmptyIndexes--;
//    if (isEmpty())
//        for (int x=0; x<size; x++) {
//            if (elements[x]==null) {
//            elements[x] = element;
//            lastFilledIndex=x;
//            break;}
//        }
    }

    @Override
    public E pop() throws StackException{
        if (isEmpty() && lastFilledIndex>=0 ) throw new StackException("Stack is Empty");//&& index<elements.length
           //return null;
        E el = elements[lastFilledIndex];
        elements[lastFilledIndex]=null;
        lastFilledIndex--;
        numberOfEmptyIndexes++;


    return el ;}

    @Override
    public E peek() {   return elements[0];  }

    @Override
    public int getSize() {  return elements.length; }

    @Override
    public boolean isEmpty() {

//      if (lastFilledIndex>=0 && elements[lastFilledIndex]==null)
//      {   return true;}

       for (int x=0; x<size; x++) {
           if (elements[x]!=null) {
               filledNumberOfIndexes++;
               return false;
           }
       }
       return true;
       // return elements[elements.length-1]==null;
    }

    @Override
    public boolean isFull() {
        int x=-1;
        while (x<elements.length) {
            x++;
            if ( x<elements.length && elements[x]==null) {
                numberOfEmptyIndexes=x-1;
            }
        }
        if (numberOfEmptyIndexes>0)
            return false;
        return true;
    }

    @Override
    public void pushAll(Collection <? extends E > src) throws StackException {
        for (E e:src) {
            push(e);
        }
//        int index=0;
//        try {
//            if (isFull()) throw new Exception();
//
//            for (E e : src) {
//                    elements[index++] =e;
//                    numberOfEmptyIndexes--;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Stack is full");
//        }
    }

    @Override
    public void popAll(Collection <? super  E > dst) throws StackException {
           while (!isEmpty()) {
               dst.add(pop());
           }

//        for (int x=0; x<elements.length; x++) {
//            src.add(elements[x]);
//            elements[x]=null;
//            numberOfEmptyIndexes++;
//        }

    }

    public static void test () {
        List <String> s = Arrays.asList("aaaa", "bd", "b");
        Collections.sort(s, new LengthComparator());
        for (String ss : s ) {
            System.out.println(ss);
        }
    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }

    public static void main(String[] args) throws StackException {
        GenericStack <Integer> stack = new GenericStack <Integer>(3);
      //  BasicConfigurator.configure();
   //     System.out.println(stack);
//        System.out.println(stack.isEmpty());
////        stack.push(10);
////        stack.push(20);
////        stack.push(30);
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.filledNumberOfIndexes);
//        System.out.println(stack);
//      //  System.out.println(stack.peek());
//        System.out.println(stack.isFull());
//        System.out.println(stack.numberOfEmptyIndexes);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack);

        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(20);
        list.add(30);


        stack.pushAll(list);
        System.out.println("Stack: "+stack);
        System.out.println("The List1: "+ list);


        List<Integer> list2 = new ArrayList<>();
        stack.popAll(list2);
        System.out.println("Stack: "+stack);
       System.out.println("List2 : "+list2);
        System.out.println("Number of empty indexes in stack: "+stack.numberOfEmptyIndexes);

        test();
    }
}
