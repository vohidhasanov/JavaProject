package WarmUp;

public class HidingExample {
    int x =10;
    String message = "this is instance variable";

    HidingExample () {
        String message ="constuctor local variable";
        System.out.println(message);
    }

    public void printLocalVariable () {
        String message = "method local variable";
        System.out.println(message);
    }

    public void printInstanceVariable () {
        String message = "method local variable-2";
        System.out.println(this.message);
    }


    public static void main(String[] args) {
        HidingExample hidingExample =new HidingExample();
        hidingExample.printLocalVariable();
        hidingExample.printInstanceVariable();
        new HidingExample().printX();

    }

    public  void printX () {
      //  System.out.println("Reference to non-static variable "+new HidingExample().x);
        System.out.println("Reference to non-static variable "+x);
    }


}
