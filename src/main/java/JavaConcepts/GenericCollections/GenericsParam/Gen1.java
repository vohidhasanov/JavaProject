package JavaConcepts.GenericCollections.GenericsParam;

public class Gen1 <K, V >{
    K object1;
    V object2;

    public Gen1(K object1, V object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public K getObject1() {
        return object1;
    }

    public V getObject2() {
        return object2;
    }

    @Override
    public String toString() {
        return "Gen1{" + "object1=" + object1 +  ", object2=" + object2 +   '}';
    }

    public static void main(String[] args) {
        Gen1 <String, String> intObj = new Gen1<>("Hello", "HI");
        Gen1 <Integer, String> strObj = new Gen1<>(10, "My string");

        System.out.println(strObj);
    }
}
