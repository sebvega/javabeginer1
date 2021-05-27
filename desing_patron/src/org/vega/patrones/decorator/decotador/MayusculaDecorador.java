package org.vega.patrones.decorator.decotador;

import org.vega.patrones.decorator.Formateable;

public class MayusculaDecorador extends TextoDecorador{
    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFomato() {
        return texto.darFomato().toUpperCase();
    }
}
