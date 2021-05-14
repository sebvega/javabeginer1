package org.vega.ejemplos.set;

import org.vega.ejemplos.modelo.Alumno;

import java.util.*;

public class ETreeSetComparable {
    public static void main(String[] args) {
        Set<Alumno> sa = new TreeSet<>((a,b)-> a.getNombre().compareTo(b.getNombre()));
        sa.add(new Alumno("miguel", 3));
        sa.add(new Alumno("paco", 4));
        sa.add(new Alumno("julio", 7));
        sa.add(new Alumno("andres", 5));
        sa.add(new Alumno("lala", 2));
        sa.add(new Alumno("ximena", 7));
        System.out.println("sa = " + sa);
    }
}
