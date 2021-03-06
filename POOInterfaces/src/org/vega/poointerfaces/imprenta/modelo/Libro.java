package org.vega.poointerfaces.imprenta.modelo;

import java.util.*;

public class Libro implements Imprimible {

    private final List<Imprimible> paginas;
    private final Persona autor;
    private final String titulo;
    private final Genero genero;


    public Libro(Persona autor, String titulo, Genero genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = new ArrayList<>();
    }

    public Libro addPagina(Imprimible pagina) {
        paginas.add(pagina);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.titulo).append("\n")
                .append("Autor: ").append(this.autor).append("\n")
                .append("Genero: ").append(this.genero).append("\n");
        for (Imprimible pagina : this.paginas) {
            sb.append(pagina.imprimir()).append("\n");
        }
        return sb.toString();
    }
}
