package org.vega.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        Stream<String> nombres = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia", "andres Mena", "andres Mena")
                .distinct();

        String resultado = nombres.reduce("resultado = ", (a, b) -> a + ", " + b);
        System.out.println(resultado);

    }
}
