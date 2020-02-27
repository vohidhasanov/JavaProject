package Func.MyWorks;

public class Calculation {
    public  My_Calculation calc;
    int z;

//static {
//    if(calc == null) calc = new My_Calculation();
//}

//public Calculation () {
//    new My_Calculation();
//}
//public Calculation (My_Calculation calc) {
//   // this.calc = calc;
//        if(this.calc == null) this.calc = new My_Calculation();
//    }

     void bark () {
        System.out.println("The Animal can bark");
    }


    public void addition (int x, int y) {
        z = x+y;
        System.out.println("The sum of given numbers: " + z);
    }



    public void substraction (int x, int y) {
        z = x - y;
        System.out.println("The substruction of given numbers: " + z);
    }

    public static void main(String[] args) {
        Calculation demo1 = new Calculation();
      //  demo1.calc.printsomething();
        demo1.calc= new My_Calculation();
        demo1.calc.multiplication(10,20);

        demo1.calc.printsomething();
        demo1.calc.multiplication(500,300);
    }
}

class My_Calculation extends Calculation{

//public My_Calculation(){
//    super ();
//}
//    public My_Calculation(My_Calculation calc ) {
//        super (calc);
//
//    }

    //int z;
   public void multiplication (int x, int y) {
        z = x * y;
        System.out.println("The product of given numbers: " + z);
    }


    public void printsomething() {
        System.out.println("Let's print something");
    }

    public static void main(String[] args) {
        int a =10, b = 20;
//        Calculation demo = new My_Calculation();
        My_Calculation demo2 = new My_Calculation();
//        demo.addition(a,b);
//        demo2.multiplication(10,20);


    }
}
