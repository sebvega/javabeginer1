package org.vega.patrones.decorator.decotador;

import org.vega.patrones.decorator.Formateable;
import org.vega.patrones.decorator.Texto;

public class EjemploDecorador {
    public static void main(String[] args) {

        Formateable texto= new Texto("hola que tal papusho");

        MayusculaDecorador mayuscula= new MayusculaDecorador(texto);
        ReversaDecorador reversa=new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayar=new SubrayadoDecorador(reversa);
        RemplazarEspaciosDecorador remplazar=new RemplazarEspaciosDecorador(subrayar);

        System.out.println("resultado final = " + remplazar.darFomato());

    }
}
