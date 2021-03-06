package org.vega.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja implements Imprimible{

    private final Persona persona;
    private final String carrera;
    private final List<String> experiencia;

    public Curriculum(Persona persona, String carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencia = new ArrayList<>();
    }

    public Curriculum addExperiencia(String exp) {
        experiencia.add(exp);
        return this;
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append(persona).append("\n")
                .append("Resumen: ").append(this.contenido)
                .append("\n").append("Profesion: ")
                .append(carrera).append("\n")
                .append("Experiencia: \n");
        for (String exp:experiencia){
            sb.append("- ").append(exp).append("\n");
        }
        return sb.toString();
    }

}
