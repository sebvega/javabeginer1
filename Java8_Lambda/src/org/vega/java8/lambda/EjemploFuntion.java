package org.vega.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFuntion {
    public static void main(String[] args) {

        Function<String, String> fun1 = (parametro) -> "hola que tal " + parametro;

        String resultado= fun1.apply("andres");
        System.out.println(resultado);

        Function<String,String> fun2=(parametro)->parametro.toUpperCase();
        System.out.println(fun2.apply("hola mundo"));

        BiFunction<String,String,String>fun3=(a,b)->a.toUpperCase().concat(b.toUpperCase());
        String r2=fun3.apply("buenos ","dias");
        System.out.println(r2);

        BiFunction<String,String,Integer>fun4=(a,b)->a.compareTo(b);
        System.out.println(fun4.apply("andres","andresa"));

        BiFunction<String,String,String>fun5=String::concat;
        System.out.println(fun5.apply("andres","andresa"));
    }
}
