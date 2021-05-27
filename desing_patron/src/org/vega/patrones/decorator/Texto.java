package org.vega.patrones.decorator;

public class Texto implements Formateable {
    private String texto;

    public Texto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String darFomato() {
        return getTexto();
    }
}
