package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        Usuario usuario = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia")
                .map(nombre->new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter(u->u.getId().equals(3))
                .findFirst()
                .get();

        System.out.println(usuario);



    }
}
