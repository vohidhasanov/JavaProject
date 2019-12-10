package WarmUp.Overfiding;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public  class Parent {

//    public Parent(String name) {
//        this.name = name;
//    }

    public Parent() {
        System.out.println(this.hashCode());;
    }

//    private String name ="Hello";
//    String surname ="Hi";
    public  void propery ()
        {  System.out.println("Parent class Propery Method");}

    public  void marry (double x)
        {  System.out.println("Parent class Marry method"); }

    public Object methodOne ()
        { System.out.println("I am Parent Object return Type method ");
    return null;}

    public void overloading() {
        System.out.println("I am overloading of Parent");
    }

}

 class Child extends Parent {

    Child () {
        System.out.println(this.hashCode());
    }


     public void marry (int x)
    {   System.out.println("Child class Marry Method");  }

    public String methodOne () {
        System.out.println("I am Child String return Type method");
        return null;  }
        public void overloading (int x) {
            System.out.println("I am overloading of Child");
        }

     }


class Test {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Parent p = new Parent();
//        p.marry(8);
//        p.methodOne();
//        p.overloading();
//        Field[] methods =  p.getClass().getDeclaredFields();
//        System.out.println(Arrays.toString(methods));

        Child c = new Child ();
//        c.marry(8.8);
//        c.marry(8);

        ((Parent)c).methodOne();
//        c.methodOne();
//        c.overloading(8);

        Parent p1 = new Child();
        ((Parent)p1).methodOne();
//        p1.marry(8.8);
//        p1.marry(8);
//        p1.methodOne();
//        p1.overloading();



    }






}


