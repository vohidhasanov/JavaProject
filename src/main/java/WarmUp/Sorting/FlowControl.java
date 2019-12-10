package WarmUp.Sorting;

public class FlowControl {
    int i =10;
    {
        methodOne();
        System.out.println("First Instance block");
    }

    FlowControl () {
        System.out.println("Flow control constructor");
    }

    public static void main(String[] args) {
        FlowControl flowControl = new FlowControl();
        System.out.println("main method");
    }

    public void methodOne ()
    {
        System.out.println(j);
    }

    {
        System.out.println("Second Instance block");
    }
    int j =20;
}
