package General;

public class Cons  {
    String author;
    String name;
    int price;
    static int addPrice;

    public Cons(String author, String name  ) {
        this.author = author;
        this.name = name;
        this.addPrice = addPrice(price);
        price=addPrice;
    }

    public int addPrice (int price)  {
       this.price = price;
       return  addPrice=price;

    }

    public static void main(String[] args) {
                Cons book = new Cons("Sheldon", "Perl");
                book.addPrice(100);

        System.out.println(book.price);
        System.out.println(book.addPrice);

        String a = "This is of last index of example" ;
        int  last = a.lastIndexOf("of", 7);
                        System.out.println(last);



  Drawble d = new Drawble() {
      @Override
      public void drwq() {
          System.out.println("I am drawing");
      }
  }; d.drwq();


  Drawble d2 = ()->{
      System.out.println("I am drawing in lambda");
  };
  d2.drwq();
    }
}
