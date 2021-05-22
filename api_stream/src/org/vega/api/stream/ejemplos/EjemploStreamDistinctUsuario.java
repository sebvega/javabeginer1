package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia","pato Guzman","pato Guzman")
                .map(nombre->new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .distinct();

        nombres.forEach(System.out::println);

    }
}
