package InterfaceExample.TeleportInterface;

public class SubServiceProvider extends DummyClass implements Inter  {

    @Override
    public void methodOne() {

    }

    @Override
    public void methodTwo() {
        System.out.println("I am methodTwo form SubServiceProvider");
    }

    public static void main(String[] args) {

        System.out.println(interfaceVariable);
        new SubServiceProvider().methodTwo();
        new SubServiceProvider().methodOne();
    }
}
