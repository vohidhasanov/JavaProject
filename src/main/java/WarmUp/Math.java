package WarmUp;

public class Math {
    public final double secret1 =2;
}

class ComplexMath extends Math {
    public final double secret2 =4;
}

class InfiniteMath extends ComplexMath {
    public final double secret3 = 8;
}

class Testermath {
    public static void main(String[] args) {
        ComplexMath math = new InfiniteMath();
        System.out.println(math.secret2);
    }
}


