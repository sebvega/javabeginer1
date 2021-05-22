package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.*;
import java.util.stream.*;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia")
                .map(nombre->new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter(u->u.getNombre().equals("pepe"))
                .peek(System.out::println);

        Optional<Usuario> usuario=nombres.findFirst();
        //lista.forEach(usuario -> System.out.println(usuario.getApellido()));
        System.out.println(usuario.get());



    }
}
