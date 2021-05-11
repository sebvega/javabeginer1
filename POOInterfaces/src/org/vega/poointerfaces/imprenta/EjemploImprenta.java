package org.vega.poointerfaces.imprenta;

import org.vega.poointerfaces.imprenta.modelo.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        Curriculum cv = new Curriculum("Juan Juanito", "ingeniero electronico", "Resumen del curriculum...");
        cv.addExperiencia("Java")
                .addExperiencia("MySQL")
                .addExperiencia("Spring Framenwork")
                .addExperiencia("Angular");

        Libro libro = new Libro("JuanitaJuancha", "El inicio del fin", Genero.TERROR);
        libro.addPagina(new Pagina("habia una vez"))
                .addPagina(new Pagina("truz"))
                .addPagina(new Pagina("fin del fin"));

        Informe informe = new Informe("Juan Juanito Perez", "Juanita", "Estudio de microservicios");

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(Imprimible imprimibre) {
        System.out.println(imprimibre.imprimir());
    }
}
