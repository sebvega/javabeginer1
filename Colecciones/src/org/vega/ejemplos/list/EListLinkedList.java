package org.vega.ejemplos.list;

import org.vega.ejemplos.modelo.Alumno;

import java.util.*;

public class EListLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> enlazada = new LinkedList<>();

        System.out.println("al: " + enlazada.size());
        System.out.println("esta vacia?:" + enlazada.isEmpty());

        enlazada.add(new Alumno("miguel", 3));
        enlazada.add(new Alumno("paco", 4));
        enlazada.add(new Alumno("julio", 7));
        enlazada.add(new Alumno("andres", 5));
        enlazada.add(new Alumno("ximena", 7));
        enlazada.add(new Alumno("lala", 2));
        enlazada.add(new Alumno("ximena", 7));

        System.out.println(enlazada + ", size: " + enlazada.size());

        enlazada.addFirst(new Alumno("zeus",7));
        enlazada.addLast(new Alumno("atenea",6));
        System.out.println(enlazada + ", size: " + enlazada.size());
        System.out.println("el primero de la lista"+enlazada.getFirst());
        System.out.println("el ultimo de la lista"+enlazada.getLast());
        System.out.println("el elemento de la lista"+enlazada.get(2));
        //el get lanza error si la lista esta Empty
        System.out.println("el primero de la lista"+enlazada.peekFirst());
        //es lo mismo que el metodo get, peso ni List==Empty, lanza Null

        //List<String> hola=enlazada.removeFirstOccurrence(enlazada(i));

                //remove arroja una Exception si esta vacio
                //poll arroja un Null si esta vacio

        ListIterator<Alumno> li=enlazada.listIterator();

        while(li.hasNext()){
            System.out.println(li.next());
        }
        System.out.println("====================================");
        while (li.hasPrevious()){
            System.out.println(li.previous());
        }

    }
}
