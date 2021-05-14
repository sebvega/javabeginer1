package org.vega.ejemplos.set;

import java.util.*;

public class EHashSetAgregar {
    public static void main(String[] args) {

        HashSet<String> hs=new HashSet<>();

        Set<String>onlySet=new HashSet<>();

        onlySet.add("uno");
        onlySet.add("dos");
        onlySet.add("tres");
        onlySet.add("cuatro");
        onlySet.add("cinco");

        System.out.println("onlySet = " + onlySet);
        
        onlySet.add("uno");

        System.out.println("onlySet = " + onlySet);

        List<String> list=new ArrayList<>(onlySet);
        Collections.sort(list);


    }
}
