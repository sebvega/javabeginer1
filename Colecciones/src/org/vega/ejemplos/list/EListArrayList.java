package org.vega.ejemplos.list;

import org.vega.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EListArrayList {
    public static void main(String[] args) {
        List<Alumno> al = new ArrayList<>();

        System.out.println("al: " + al.size());
        System.out.println("esta vacia?:" + al.isEmpty());

        al.add(new Alumno("miguel", 3));
        al.add(new Alumno("paco", 4));
        al.add(new Alumno("julio", 7));
        al.add(new Alumno("andres", 5));
        al.add(new Alumno("ximena", 7));
        al.add(2, new Alumno("lala", 2));//agrega en la posicion 2
        al.set(3,new Alumno("ximena", 7));//remplaza en la posicion 3

        System.out.println(al + ", size: " + al.size());

        al.remove(new Alumno("miguel", 3));//elimina el elemento exacto, si no esta no hace nada
        al.remove(0);//elimina el que este en la posicion

        System.out.println(al + ", size: " + al.size());
        boolean b=al.contains(new Alumno("ximena",7));
        System.out.println("contiene a ximena? = " + b);

        Object[] a=al.toArray();
        for (int i=0;i<a.length;i++){
            System.out.println("desde el arreglo: "+a[i]);
        }

    }
}
