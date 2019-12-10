package JavaConcepts.GenericCollections;

import java.util.Arrays;

public class ComparableExample implements Comparable <ComparableExample> {
    private String fruitName;
    private String fruitDesc;
    private int quantity;


    public ComparableExample(String fruitName, String fruitDesc, int quantity) {
        super();
        this.fruitName = fruitName;
        this.fruitDesc = fruitDesc;
        this.quantity = quantity;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitDesc() {
        return fruitDesc;
    }

    public void setFruitDesc(String fruitDesc) {
        this.fruitDesc = fruitDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public int compareTo(ComparableExample compareFruits) {
        int compareQuantity = compareFruits.getQuantity();
        //return this.quantity-compareQuantity;
        return compareQuantity-this.quantity;
    }


    public static void main(String[] args) {
        ComparableExample [] fruits = new ComparableExample[4];

        ComparableExample pineApple = new ComparableExample("Pineapple", "Pineapple Description", 70);
        ComparableExample apple = new ComparableExample("Apple", "Apple Description", 100);
        ComparableExample orange = new ComparableExample("Orange", "Orange Description", 80);
        ComparableExample banana =  new ComparableExample("Banana", "Banana Description", 90);

        fruits[0] = pineApple;
        fruits[1]=apple;
        fruits[2]=orange;
        fruits[3]=banana;

        Arrays.sort(fruits);

        int i=0;
        for (ComparableExample fruit: fruits) {
        System.out.println("fruits "+ ++i +" : "+fruit.getFruitName()+ ", Quantity : "+ fruit.getQuantity());
    }
    }


}
