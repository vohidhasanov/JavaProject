package WarmUp;


public class Automobile {
     private final  String drive() {return "Drive Automobile";}
    }

 class Car extends Automobile {
protected String drive(){return"Driving a car";}
}


    class ElectroCar extends Car {
    public final String drive () {return "Driving electrocar";}
    }

    class TestAuto {
        public static void main(String[] args) {
            final Car car = new ElectroCar ();
            System.out.println(car.drive());
        }
    }