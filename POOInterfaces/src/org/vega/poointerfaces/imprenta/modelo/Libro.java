package org.vega.poointerfaces.imprenta.modelo;

import java.util.*;

public class Libro implements Imprimible {

    private List<Imprimible> paginas;
    private String autor;
    private String titulo;
    private Genero genero;


    public Libro(String autor, String titulo, Genero genero) {
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
