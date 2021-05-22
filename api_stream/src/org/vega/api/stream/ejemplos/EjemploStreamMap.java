package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.*;
import java.util.stream.*;

public class EjemploStreamMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena")
                .map(nombre->new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(u-> System.out.println(u.getNombre()))
                .map(usuario -> {
                    String first = usuario.getNombre().toUpperCase();
                    usuario.setNombre(first);
                    //String last= usuario.getApellido().toLowerCase();
                    return usuario;
                });

        List<Usuario> lista=nombres.collect(Collectors.toList());
        //lista.forEach(System.out::println);
        lista.forEach(usuario -> System.out.println(usuario.getApellido()));
        lista.forEach(System.out::println);


        //nombres.forEach(System.out::println);

    }
}
