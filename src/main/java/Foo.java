public class Foo {
    private String attribute;

    public Foo(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "attribute='" + attribute + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Foo f = new Foo("f");
        changeReferench(f);
        System.out.println("The variable of f is =" + f);
    }

    private static void changeReferench(Foo a) {
        Foo b = new Foo ("b");
        a=b;
        System.out.println("The variable a is = " + a);

    }

}
