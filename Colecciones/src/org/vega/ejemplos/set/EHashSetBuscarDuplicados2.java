package org.vega.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EHashSetBuscarDuplicados2 {

    public static void main(String[] args) {

        String[] peses = {"12", "12", "11", "12", "13", "14", "14"};


        Set<String> unicos = new HashSet<>();
        Set<String> duplicados=new HashSet<>();

        for (String pez : peses) {
            if (!unicos.add(pez)) {
                duplicados.add(pez);
            }
        }
        unicos.removeAll(duplicados);
        System.out.println("duplicados = " + duplicados);
        System.out.println("unicos = " + unicos);
    }
}
