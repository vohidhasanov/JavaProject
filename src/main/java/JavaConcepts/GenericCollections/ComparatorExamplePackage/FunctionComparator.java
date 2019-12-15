package JavaConcepts.GenericCollections.ComparatorExamplePackage;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;

public class FunctionComparator <T> implements Comparator <T> {
    CompareFunction <T> function;

    public FunctionComparator(CompareFunction function) {
        this.function = function;
    }

    @Override
    public int compare(T t1,
                       T t2) {
        return function.apply(t1)
                .compareTo(function.apply(t2));
    }


    public static <T> Comparator <T> createGetterComparator (Class<T> clazz, String getterName) throws Exception {
        final Method getter = clazz.getMethod(getterName);
//        PropertyDescriptor pd = new PropertyDescriptor("Name", clazz);
//        Method getter = pd.getReadMethod();
        return new FunctionComparator<>(new CompareFunction()
        {
            @Override
            public Comparable apply(Object object)
            {
                try
                {
                  return (Comparable) getter.invoke(object);
                }
                catch (Exception e)
                {   e.printStackTrace();
                    return null;
                }
            }
        } );

    }
}
