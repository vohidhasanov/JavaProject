package General;

public interface A_Interface {
    default void m() {
     //   System.out.println("I am from A interface");
    }
}

 interface B_Interface extends A_Interface {
    default void m() {
        //System.out.println("I am from B interface");
    }
}

class C implements A_Interface, B_Interface {


    public static void main(String[] args) {
    C cClass = new C();
    cClass.m();


    }


    @Override
    public void m() {

        System.out.println("Hello I am overriding ");
    }
}
