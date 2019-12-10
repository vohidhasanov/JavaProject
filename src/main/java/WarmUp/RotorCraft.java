package WarmUp;

import java.awt.*;

public class RotorCraft {
    protected final int height =5;

    int fly() {
        return this.height;
    }
    }

    class Helicopter extends RotorCraft {
    private int height =10;

    protected int fly() {return super.height;}
    }

    class Tester {
        public static void main(String[] args) {
            Helicopter h = new Helicopter();
         //   System.out.println(h.fly());

            Helicopter hh =(Helicopter)  new RotorCraft(); // ClassCastException
            RotorCraft rr = new Helicopter();
            rr.fly();
            hh.fly();



        }

    }
