package Func.MyWorks;

public class Singleton {
    private static Singleton single_instance=null;
    public String s;

    private Singleton () {
        s="Hello to everyon";
    }

    public static Singleton Singleton() {
        if (single_instance == null)
            single_instance = new Singleton();
        return single_instance;
    }
}
 class Main {
     public static void main(String[] args) {

         Singleton x = Singleton.Singleton();
         Singleton y = Singleton.Singleton();
         x.s = x.s.toUpperCase();
         y.s = y.s.toUpperCase();

         System.out.println("String from x is "+ x.s);
         System.out.println("String from y is "+ y.s);
     }
 }