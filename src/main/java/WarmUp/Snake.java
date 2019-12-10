package WarmUp;

public class Snake {

    public void SnakeEat() {
        System.out.println("Snake eat");
    }
}

class Coblra extends Snake {
    int snakeSize =20;

    public void SnakeEat() {
        System.out.println("Coblra eat");
    }

    public void CobraEat() {
        System.out.println("2-Cobra eats..");
    }
 }
 class GardenSnake {}

 class SnakeHamdler {
    private Snake snake;

    public void setSnake (Snake snake, int snakeSize)
    {
        System.out.println("It is Snake "+snake +" and size is "+ snakeSize);
    }



     public static void main(String[] args) {
        Coblra s = new Coblra();
     //   s.CobraEat();
      SnakeHamdler sss = new SnakeHamdler();

      sss.setSnake(new Snake (), 10);

     }
 }

