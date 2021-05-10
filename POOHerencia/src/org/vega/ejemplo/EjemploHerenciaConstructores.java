package org.vega.ejemplo;

import org.vega.pooherencia.*;

public class EjemploHerenciaConstructores {
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
        System.out.println("imprimiendo datos de persona");
        System.out.println("-------------------------------");
        System.out.println("nomrbre: " + persona.getNombre()
                + ",apellido: " + persona.getApellido()
                + ",edad: " + persona.getEdad()
                + ",email: " + persona.getEmail());

        if (persona instanceof Alumno) {
            System.out.println("Imprimiendo datos Alumno");
            System.out.println("-------------------------------");
            System.out.println("institucion: " + ((Alumno) persona).getInstitucion());
            System.out.println("nota Matematicas: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("nota historia: " + ((Alumno) persona).getNotaHistoria());
            System.out.println("nota espaniol: " + ((Alumno) persona).getNotaEspaniol());
            if (persona instanceof AlumnoInternacional) {
                System.out.println("Imprimiendo datos Alumno internacional");
                System.out.println("-------------------------------");
                System.out.println("nota idiomas: " + ((AlumnoInternacional) persona).getNotaIdiomas());
                System.out.println("pais: " + ((AlumnoInternacional) persona).getPais());

            }
        }
        if (persona instanceof Profesor) {
            System.out.println("imprimiendo datos profesor");
            System.out.println("-------------------------------");
            System.out.println("asignatura: " + ((Profesor) persona).getAsignatura());
        }
        System.out.println("==============sobre escritura==================");
        System.out.println(persona.saludar());
        System.out.println("================================");
    }
}
