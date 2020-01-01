package JavaConcepts.GenericCollections.GenericsExamples;

public class GenRunner {

    public static void main(String[] args) {
        GenericExample_1 <Integer> intObject = new GenericExample_1(10);
        GenericExample_1<String> strObject = new GenericExample_1("hello");

        GenericExample_2 <Integer, String> object = new GenericExample_2<>(10, "Hello");
        GenericExample_2 <String, Integer> object2 = new GenericExample_2<>("Hello2", 20);

        GenericExample_3 <Integer> object3  = new GenericExample_3(3);
       object3.show();

     //   GenericExample_4 <Animal> object4 = new GenericExample_4<Animal>(new Animal(10));
        GenericExample_4 <Cat> object4 = new GenericExample_4<>(new Cat());
        object4.show();

        GenericExample_5 <CatSer> object5 = new GenericExample_5<CatSer>(new CatSer());
        object5.show();

        GenericExample_6 <Integer> i1 = new GenericExample_6<>(20);
        GenericExample_6<Integer> i2 = new GenericExample_6 <> (40);
        i1.showData(i2);

        GenericExample_6<Float> f1 = new GenericExample_6 <> ( 40.0f);
        i1.showData(f1);

            String [] strings = {"kitty", "tom", "sharik"};
        GenericExample_8 <String> genericExample_8 = new GenericExample_8<>(strings);
        System.out.println("the minimum value is: "+genericExample_8.min());
            Integer [] integers = {10,2,3,4};
        GenericExample_8 <Integer> genericExample_81 = new GenericExample_8<>(integers);
        System.out.println("the minimum value is: "+genericExample_81.min());

    }

}
