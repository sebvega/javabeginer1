package org.vega.patrones.decorator.decotador;

import org.vega.patrones.decorator.Formateable;

public class ReversaDecorador extends TextoDecorador{
    public ReversaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFomato() {
        StringBuilder sb=new StringBuilder(texto.darFomato());
        return sb.reverse().toString();
    }
}
