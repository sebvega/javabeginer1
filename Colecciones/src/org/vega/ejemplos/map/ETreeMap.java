package org.vega.ejemplos.map;

import java.util.*;

public class ETreeMap {
    public static void main(String[] args) {

        //Map<String, Object> persona = new TreeMap<>((a,b)->b.compareTo(a));
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length));
        persona.put("nombre", "Jhon");
        persona.put("apellido", "Doe");
        persona.put("email", "jhon@correo.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new TreeMap<>();

        direccion.put("pais", "USA");
        direccion.put("estado", "california");
        direccion.put("ciudad", "santa barbara");
        direccion.put("calle", "one street");
        direccion.put("numero", "1234");

        persona.put("direccion", direccion);
        System.out.println("persona: "+persona);


    }
}
