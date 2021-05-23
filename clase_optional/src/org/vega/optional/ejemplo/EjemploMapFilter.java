package org.vega.optional.ejemplo;

import org.vega.optional.ejemplo.models.Computador;
import org.vega.optional.ejemplo.models.Fabricante;
import org.vega.optional.ejemplo.models.Procesador;
import org.vega.optional.ejemplo.repository.ComputadorRepository;
import org.vega.optional.ejemplo.repository.Repositorio;

public class EjemploMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();

        //Computador defecto=new Computador("HP","Bug");
        String oferta = repositorio.filtrar("asus")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fil->"amd".equalsIgnoreCase(fil.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("desconocido");
                //.orElseThrow();
        System.out.println("procesador = " + oferta);
    }
}
