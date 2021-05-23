package org.vega.optional.ejemplo;

import org.vega.optional.ejemplo.models.Computador;
import org.vega.optional.ejemplo.repository.ComputadorRepository;
import org.vega.optional.ejemplo.repository.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();

        repositorio.filtrar("asus").ifPresentOrElse(System.out::println,
                () -> System.out.println("no se encontro"));


        /*Optional<Computador> pc = repositorio.filtrar("asus rog");
        if (pc.isPresent()) {
            System.out.println(pc.get());
        } else {
            System.out.println("no se encontro");
        }*/
    }
}
