package org.vega.ejemplo;

import org.vega.pooherencia.Alumno;
import org.vega.pooherencia.AlumnoInternacional;
import org.vega.pooherencia.Persona;
import org.vega.pooherencia.Profesor;

public class EjemploHerenciaConstructoresToString {
    public static void main(String[] args) {

        System.out.println("------------creando estudiante------------");
        Alumno est = new Alumno();
        est.setNombre("sebastian");
        est.setApellido("vega");
        est.setEdad(15);
        est.setInstitucion("INEM");
        est.setNotaEspaniol(5.5);
        est.setNotaHistoria(6.0);
        est.setNotaMatematica(7.0);

        System.out.println("------------creando estudiante internacional------------");
        AlumnoInternacional estInt = new AlumnoInternacional();
        estInt.setNombre("laura");
        estInt.setApellido("mancilla");
        estInt.setEdad(14);
        estInt.setInstitucion("INEM");
        estInt.setNotaEspaniol(5);
        estInt.setNotaHistoria(5.5);
        estInt.setNotaMatematica(6.0);
        estInt.setNotaIdiomas(6.5);
        estInt.setPais("canada");


        System.out.println("------------creando profesor------------");
        Profesor maestro = new Profesor();
        maestro.setNombre("Magda");
        maestro.setApellido("Del Pilar");
        maestro.setAsignatura("Matematicas");


        System.out.println("===================================");
        imprimir(est);
        imprimir(estInt);
        imprimir(maestro);

    }

    public static void imprimir(Persona persona) {
        System.out.println("=========================================");
        System.out.println(persona);
    }
}
