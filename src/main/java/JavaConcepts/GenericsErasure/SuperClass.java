package JavaConcepts.GenericsErasure;

import WarmUp.Overfiding.Parent;

public class SuperClass {
    public static Class getCommonSuperClass (final Class clazz1, final Class clazz2, final boolean doSuper) {
        final Class c1 = doSuper ? clazz1.getSuperclass():clazz1;
        final Class c2 = doSuper ? clazz2.getSuperclass():clazz2;
        if (c1==null || c2==null) {
            return Object.class;
        }
        if (c1.equals(c2)) {
            return c1;
        }
        Class result = getCommonSuperClass(c1.getSuperclass(), c2, false);

        if (!result.equals(Object.class))
            return result  ;
        result = getCommonSuperClass(c1, c2.getSuperclass(), false);
        if (!result.equals(Object.class)) {
            return result;
        }
        return getCommonSuperClass(c1.getSuperclass(), c2.getSuperclass(), false);
    }

    public static Class getCommonSuperClass (final Class clazz1, final Class clazz2) {
        return getCommonSuperClass(clazz1, clazz2, true);
    }

    public static void main(String[] args) {
        //System.out.println(getCommonSuperClass(java.lang.Double.class, java.lang.Character.class));
        System.out.println(getCommonSuperClass(Child.class, Child2.class));
    }
}

class Child extends Parent1 {}
class Child2 extends Parent{}

class Parent1{}
