package Func.MyWorks;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

interface Foo {
    String method (String string);
    //int method2 (int string);

//    String process (Callable<String> c) throws Exception;
//    String process (Supplier<String> s);
}

public class Sample3 {
    String value="Enclosing scope value11";
    public String add (String string, Function<String,String> fn) {

        return fn.apply(string);
    }


//    public String add (String string, Foo foo) {
//    return foo.method(string);
//    }

    public static void main(String[] args)  {
        String value= "Class instance value";
//        Foo foo = parametr->
//                parametr+10;
//        String result = new Sample3()
//                .add("Message", foo);
//        System.out.println(result);

//        Function <String, String> fn = pararmetr -> pararmetr+" from Lambda";
//        String result = new Sample3().add("Message", fn);
//        System.out.println(result);

       // System.out.println(new Sample3().ScopeExperiment());
        Foo foo = parametr -> new Sample3().buildString(parametr);
        System.out.println(foo.method("Hello "));

    
    }
    private String buildString (String parametr) {
        String result = "Something " + parametr;
        return result;
    }

    private String ScopeExperiment () {
        Foo ff = new Foo() {
            String value = "Inner class value";
            @Override
            public String method(String string) {
                return this.value;
            }
        };
        String  resultIC = ff.method("");


        Foo ffLambda = parametr -> {
            String value = "Lambda value";
            return this.value;
        };

        String resultLamda = ffLambda.method("");
            return "Results: resultIC: " + resultIC + " ,resultLamda: " + resultLamda;}
        }





