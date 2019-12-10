package JavaConcepts.GenericCollections;

import sun.font.FontRunIterator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample  implements Comparable<ComparatorExample> {
        private String fruitName;
        private String fruitDesc;
        private int quantity;


        public ComparatorExample(String fruitName, String fruitDesc, int quantity) {
            super();
            this.fruitName = fruitName;
            this.fruitDesc = fruitDesc;
            this.quantity = quantity;
        }

        public String getFruitName() { return fruitName;  }
        public void setFruitName(String fruitName) {this.fruitName = fruitName;}
        public String getFruitDesc() {   return fruitDesc;  }
        public void setFruitDesc(String fruitDesc) {  this.fruitDesc = fruitDesc;  }
        public int getQuantity() { return quantity;  }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        @Override
        public int compareTo(JavaConcepts.GenericCollections.ComparatorExample compareFruits) {
            int compareQuantity = compareFruits.getQuantity();
            //return this.quantity-compareQuantity;
            return this.quantity-compareQuantity;
        }

        public static Comparator <ComparatorExample> FruitNameComparator
                = new Comparator<ComparatorExample>() {
            @Override
            public int compare(ComparatorExample fruit1, ComparatorExample fruit2) {
                String fruitName1 = fruit1.getFruitName().toUpperCase();
                String fruitName2 = fruit2.getFruitName().toUpperCase();
                return fruitName1.compareTo(fruitName2);
            }
        };

        public static void main(String[] args) {
            ComparatorExample[] fruits = new JavaConcepts.GenericCollections.ComparatorExample[5];

            ComparatorExample pineApple = new ComparatorExample("Pineapple", "Pineapple Description", 70);
            ComparatorExample apple = new ComparatorExample("Apple", "Apple Description", 100);
            ComparatorExample orange = new ComparatorExample("Orange", "Orange Description", 80);
            ComparatorExample banana =  new ComparatorExample("Banana", "Banana Description", 90);
            ComparatorExample aaaa = new ComparatorExample("AAAA", "AAA", 10);

            fruits[0] = pineApple;
            fruits[1]=apple;
            fruits[2]=orange;
            fruits[3]=banana;
            fruits[4]=aaaa;
            String [] aaa = new String[1];
            //aaa[0] ={"fsfsdf", "fdsfdsf"};


            Arrays.sort(fruits, ComparatorExample.FruitNameComparator);
            //Arrays.sort(fruits, new TempComp());


            int i=0;
            for (JavaConcepts.GenericCollections.ComparatorExample fruit: fruits) {
                System.out.println("fruits "+ ++i +" : "+fruit.getFruitName()+ ", Quantity : "+ fruit.getQuantity());
            }
        }


    }


