package org.vega.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ETreeSet {
    public static void main(String[] args) {

        Set<String> ts =new TreeSet<>((a,b) -> b.compareTo(a));
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cuatro");
        ts.add("cinco");
        System.out.println("ts = " + ts);
        //para invertir el orden es pone en el () ->/// (a,b) -> b.compareTo(a)       Comparator.reverseOrder()
        Set<Integer>numeros=new TreeSet<>(Comparator.reverseOrder());
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(15);
        numeros.add(12);
        numeros.add(11);
        System.out.println("numeros = " + numeros);
        
        
    }
}
