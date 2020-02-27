package Func.MyWorks.CallingBack;

public class MyClass implements SomeClass.CallBack{

    @Override
    public void callingBack(String s) {
        if (s!= null) {
            System.out.println("Your answer is " + s);
        }
        else {
            System.out.println("You didn't answer a question");
        }

    }


}
class Main {

    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        MyClass myClass = new MyClass();
        someClass.registerCallBack(myClass);
        someClass.dosomething();
    }
}