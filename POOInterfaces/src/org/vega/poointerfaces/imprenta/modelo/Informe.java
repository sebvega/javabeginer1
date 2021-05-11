package org.vega.poointerfaces.imprenta.modelo;

public class Informe extends Hoja implements Imprimible{

    private Persona autor;
    private String revisor;


    public Informe(Persona autor,String editor, String contenido) {
        super(contenido);
        this.autor=autor;
        this.revisor =editor;
    }

    @Override
    public String imprimir() {
        return "informe escrito por: "+ autor
                + " revisado por: "+ revisor
                + "\n"+this.contenido;
    }
}
