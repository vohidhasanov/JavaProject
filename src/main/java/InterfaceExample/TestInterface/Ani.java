package InterfaceExample.TestInterface;

interface Ani {
    public void singable();
}

class A1 implements Ani{
    String name;
    int age;

    @Override
    public String toString() {
        return "A1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void singable() {
        System.out.println("I can sing A1 Class");
    }
}

class D1 extends A1 implements Ani {
    @Override
    public void singable() {
        System.out.println("I can sing D1 Class");
    }

    public static void main(String[] args) {
        A1 a = new A1();
        D1 d = new D1();
        d.age = 30;
        d.name ="Bob";
        a.age  =15;
        a.name ="Jack";

        System.out.println(a);
        System.out.println(d);
//        a.singable();
        new D1().printInter(a);
        new D1().printInter(d);


    }

    public void printInter (A1 singable) {
        singable.singable();
    }
}