package org.vega.ejemplos.list;

import org.vega.ejemplos.modelo.Alumno;

import java.util.*;

public class EListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("miguel", 3));
        sa.add(new Alumno("paco", 4));
        sa.add(new Alumno("julio", 7));
        sa.add(new Alumno("andres", 5));
        sa.add(new Alumno("ximena", 7));
        sa.add(new Alumno("lala", 2));
        sa.add(new Alumno("ximena", 7));
        //Collections.sort(sa,(a,b)->b.getNombre().compareTo(a.getNombre()));
        //sa.sort((a,b)->b.getNombre().compareTo(a.getNombre()));
        sa.sort(Comparator.comparing((Alumno a)->a.getNombre()));//al derecho
        sa.sort(Comparator.comparing((Alumno a)->a.getNombre()).reversed());//al reves
        sa.sort(Comparator.comparing(Alumno::getNombre).reversed());//el mismo orden con el metodo de referencia
        System.out.println("sa = " + sa);

        System.out.println("iterando con un stream forEach===================");
        sa.forEach(System.out::println);
    }
}
