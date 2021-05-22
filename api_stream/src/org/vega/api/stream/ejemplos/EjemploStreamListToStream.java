package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();

        lista.add(new Usuario("andres", "zapata"));
        lista.add(new Usuario("pepe", "gonzales"));
        lista.add(new Usuario("luci", "martinez"));
        lista.add(new Usuario("cata", "perez"));
        lista.add(new Usuario("lalo", "mena"));
        lista.add(new Usuario("ernesto", "lopez"));

        //lista.stream()
          Stream<String>nombres=lista.stream()
                .map(e -> e.getNombre().toUpperCase()
                        .concat(" ")
                        .concat(e.getApellido().toUpperCase()))
                .flatMap(e -> {
                    if (e.contains("pepe".toUpperCase())) {
                        return Stream.of(e);
                    } else
                        return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);
        System.out.println(nombres.count());

    }
}
