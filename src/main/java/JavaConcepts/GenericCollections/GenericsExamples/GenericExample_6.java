package JavaConcepts.GenericCollections.GenericsExamples;

public class GenericExample_6  <T extends Number>{
    T number;

    public GenericExample_6(T number) {
        this.number = number;
    }

    //raw without <T> parametr's because Generics has been erased after one time use
    // or we should pur <?>

    // void showData (GenericExample6 <?> { * wildcard any type
    //void showData (GenericExample_6 <T>) {
    void showData (GenericExample_6  operand) {
        System.out.println(number.doubleValue() - operand.number.doubleValue());
    }
}
