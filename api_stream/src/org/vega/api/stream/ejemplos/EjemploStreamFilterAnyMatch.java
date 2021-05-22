package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {

        boolean existe = Stream
                .of("pato Guzman", "pepe Gonzales", "andres Mena", "pepe Garcia")
                .map(nombre->new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .anyMatch(u->u.getId().equals(3));

        System.out.println(existe);



    }
}
