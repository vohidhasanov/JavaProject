package JavaConcepts.StaticBinding;



public class NewClass {

    public static class superclass {

        void print ()
        {
            System.out.println("SuperClass method called");
        }
    }
    public static class subclass extends superclass {
         void print ()
        {
            System.out.println("SubClass method called");

        }

    }

    public static void main(String[] args) {
        superclass a = new subclass();
        subclass s = new subclass();
        superclass a1 = new subclass();

        a.print();
        s.print();
        a1.print();
    }
}
