package org.vega.optional.ejemplo;

import org.vega.optional.ejemplo.models.Computador;
import org.vega.optional.ejemplo.repository.ComputadorRepository;
import org.vega.optional.ejemplo.repository.Repositorio;

import java.util.Optional;

public class EjemploOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();


        Computador oferta = repositorio.filtrar("rog").orElseThrow(IllegalStateException::new);
        System.out.println("oferta = " + oferta);

        String archivo = "documento.pdf";
        String extencion = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println("extencion = " + extencion);

    }
}
