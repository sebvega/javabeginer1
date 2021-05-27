package org.vega.patrones.decorator.decotador;

import org.vega.patrones.decorator.Formateable;

public class RemplazarEspaciosDecorador extends TextoDecorador{
    public RemplazarEspaciosDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFomato() {
        return texto.darFomato().replace(" ","_");
    }
}
