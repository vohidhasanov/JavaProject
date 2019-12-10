package WarmUp;

public class NestedClassExample {
    static class Char
    { char c;
        Char (char c)
        {
            this.c = c;
        }

        public void print ()
        {
           System.out.print(c);
        }


    }


    public static void main(String[] args) {
        typeText(new Char('A'));
        typeText(new Char('B')
        {
            public void print ()
            {
                System.out.print("[");
                super.print();
                System.out.println("]");
            }

        });
    }

    private static void typeText (Char c) {
        c.print();


    }
}
