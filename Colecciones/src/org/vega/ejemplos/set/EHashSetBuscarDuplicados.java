package org.vega.ejemplos.set;

import java.util.*;

public class EHashSetBuscarDuplicados {

    public static void main(String[] args) {

        String[] peses = {"12", "12", "11", "12", "13", "14", "14"};

        Set<String> unicos = new HashSet<>();
        for (String pez : peses) {
            if (!unicos.add(pez)) {
                System.out.println("elemento duplicado" + pez);
            }
        }
    }
}
