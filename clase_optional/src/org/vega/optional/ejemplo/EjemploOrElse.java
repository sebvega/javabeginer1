package org.vega.optional.ejemplo;

import org.vega.optional.ejemplo.models.Computador;
import org.vega.optional.ejemplo.repository.*;

public class EjemploOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepository();

        //Computador defecto=new Computador("HP","Bug");
        Computador oferta=repositorio.filtrar("put").orElse(valorDefecto());
        System.out.println("oferta = " + oferta);
        oferta=repositorio.filtrar("mac").orElseGet(EjemploOrElse::valorDefecto);
        System.out.println("oferta = " + oferta);


    }
    public static Computador valorDefecto(){
        System.out.println("obteniendo valor por defecto");
        return new Computador("HP","Bug");
    }
}
