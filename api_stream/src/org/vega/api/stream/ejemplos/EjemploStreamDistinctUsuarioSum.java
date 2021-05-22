package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        IntStream largoNombres = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia", "pato Guzman", "pato Guzman")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct()
                .mapToInt(e -> e.toString().length())
                .peek(System.out::println);

        IntSummaryStatistics elemento = largoNombres.summaryStatistics();

        System.out.println(elemento);

    }
}
