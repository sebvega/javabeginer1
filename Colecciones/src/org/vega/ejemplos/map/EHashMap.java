package org.vega.ejemplos.map;

import java.util.*;

public class EHashMap {
    public static void main(String[] args) {

        Map<String,String> persona=new HashMap<>();
        persona.put("nombre","Jhon");
        persona.put("apellido","Doe");
        persona.put("email","jhon@correo.com");
        persona.put("edad","30");

        System.out.println("persona = " + persona);
        String nombre=persona.get("nombre");
        System.out.println("nombre = " + nombre);

        //eliminar
        String apellido=persona.remove("apellido");

        boolean esta= persona.containsKey("apellido");
        System.out.println("esta = " + esta);

        Collection<String> valores=persona.values();
        for (String v:valores){
            System.out.println("v = " + v);
        }
        for(Map.Entry<String,String>par:persona.entrySet()){
            System.out.println(par.getKey()+" => " + par.getValue());
        }
        System.out.println();
        for (String llave:persona.keySet()){
            String valor=persona.get(llave);
            System.out.println(llave+ " => " + valor);
        }


    }
}
