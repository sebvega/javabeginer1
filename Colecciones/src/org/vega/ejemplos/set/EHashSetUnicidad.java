package org.vega.ejemplos.set;

import org.vega.ejemplos.modelo.Alumno;

import java.util.*;

public class EHashSetUnicidad {
    public static void main(String[] args) {
        Set<Alumno> sa = new HashSet<>();
        sa.add(new Alumno("miguel", 3));
        sa.add(new Alumno("paco", 4));
        sa.add(new Alumno("julio", 7));
        sa.add(new Alumno("andres", 5));
        sa.add(new Alumno("lala", 2));
        sa.add(new Alumno("ximena", 7));
        System.out.println("sa = " + sa);

        System.out.println("iterando usando un foreach=========================");
        for(Alumno a:sa){
            System.out.println("a = " + a);
        }
        System.out.println("iterando con un while e iterator===================");
        Iterator<Alumno>it=sa.iterator();

        while (it.hasNext()){
            Alumno a=it.next();
            System.out.println("a = " + a);
        }
        System.out.println("iterando con un stream forEach===================");
        sa.forEach(System.out::println);
        //son alternativas
        System.out.println("alternativa de las formas lambda, muestra numeros repetidos, porqe el" +
                "compareTo en Alumno usa los nombres");
        sa.forEach(a-> System.out.println(a.getNota()));

    }
}
