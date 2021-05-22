package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia")
                .map(nombre->new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter(u->u.getNombre().equals("pepe"))
                .peek(System.out::println);

        List<Usuario> lista=nombres.collect(Collectors.toList());
        //lista.forEach(usuario -> System.out.println(usuario.getApellido()));
        lista.forEach(System.out::println);



    }
}
