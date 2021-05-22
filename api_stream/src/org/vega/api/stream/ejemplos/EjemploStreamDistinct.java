package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {

        //Stream<String> nombres = Stream
        Stream.of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia","andres Mena","andres Mena")
                .distinct()
                .forEach(System.out::println);

    }
}
