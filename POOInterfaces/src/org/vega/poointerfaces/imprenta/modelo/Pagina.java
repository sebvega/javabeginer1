package org.vega.poointerfaces.imprenta.modelo;

public class Pagina extends Hoja implements Imprimible{



    public Pagina(String contenido) {
        super(contenido);
    }

    public String imprimir() {
        return this.contenido;
    }
}
