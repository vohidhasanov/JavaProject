package JavaConcepts.GenericCollections.ComparatorExamplePackage;

import WarmUp.ArrayListExample;

import java.util.*;

public class Laptop {
    private String name;
    private int ram;
    private int price;

    public Laptop(String name, int ram, int price) {
        this.name = name;
        this.ram = ram;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Comparator <Laptop> com
            = new Comparator<Laptop>() {
        @Override
        public int compare(Laptop laptop1, Laptop laptop2) {
            Integer price1 = laptop1.getPrice();
            Integer price2 = laptop2.getPrice();
            String name1 = laptop1.getName();
            String name2 = laptop2.getName();
            return name1.compareTo(name2);
        }
    };

    @Override
    public String toString() {
         return String.format("%-1s    %d  %d%n", getName(), getRam(), getPrice());
    }
}

class Runner {

    public static void main(String[] args) throws Exception {
        List<Laptop> laptopList = new ArrayList<>();
        laptopList.add(new Laptop("Dsus", 16, 800));
        laptopList.add(new Laptop("Zpple", 8, 1000));
        laptopList.add(new Laptop("Acer", 12, 500));
        laptopList.add(new Laptop("Yellow", 14, 700));

     //  laptopList.sort(Laptop.com);

//        Collections.sort(laptopList, new FunctionComparator<>(new CompareFunction <Laptop>() {
//            @Override
//            public Comparable apply(Laptop object) {
//                return object.getName();
//            }
//        }));


            Collections.sort(laptopList, FunctionComparator.createGetterComparator(Laptop.class, "getPrice"));

        System.out.println(laptopList);

        }



    }

