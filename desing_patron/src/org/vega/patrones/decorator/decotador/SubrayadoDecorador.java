package org.vega.patrones.decorator.decotador;

import org.vega.patrones.decorator.Formateable;

public class SubrayadoDecorador extends TextoDecorador{
    public SubrayadoDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFomato() {
        int largo=texto.darFomato().length();
        StringBuilder sb=new StringBuilder(texto.darFomato());
        sb.append("\n");
        for (int i=0;i<largo;i++){
            sb.append("_");
        }
        return sb.toString();
    }
}
