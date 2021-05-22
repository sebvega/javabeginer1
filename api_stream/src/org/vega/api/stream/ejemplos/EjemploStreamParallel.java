package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();

        lista.add(new Usuario("andres", "zapata"));
        lista.add(new Usuario("pepe", "gonzales"));
        lista.add(new Usuario("luci", "martinez"));
        lista.add(new Usuario("cata", "perez"));
        lista.add(new Usuario("lalo", "mena"));
        lista.add(new Usuario("ernesto", "lopez"));
        long t1 = System.currentTimeMillis();
        //lista.stream()
        String resultados = lista.stream()
                .parallel()
                .map(e -> e.toString().toUpperCase())
                .peek(e -> {
                    System.out.println("nombre del Thread: " + Thread.currentThread().getName()
                            + " - " + e);
                })
                .flatMap(e -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    if (e.contains("lalo".toUpperCase())) {
                        return Stream.of(e);
                    } else
                        return Stream.empty();
                })
                .findAny().orElse("");
        long t2 = System.currentTimeMillis();

        System.out.println(resultados);
        System.out.println("tiempo: " + (t2 - t1));
    }
}
