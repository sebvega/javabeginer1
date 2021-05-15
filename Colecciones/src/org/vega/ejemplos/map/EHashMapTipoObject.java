package org.vega.ejemplos.map;

import java.util.*;

public class EHashMapTipoObject {
    public static void main(String[] args) {

        Map<String, Object> persona = new HashMap<>();
        persona.put("nombre", "Jhon");
        persona.put("apellido", "Doe");
        persona.put("email", "jhon@correo.com");
        persona.put("edad", "30");

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "california");
        direccion.put("ciudad", "santa barbara");
        direccion.put("calle", "one street");
        direccion.put("numero", "1234");

        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);
        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);

        //eliminar
        String apellido = (String) persona.remove("apellido");

        boolean esta = persona.containsKey("apellido");
        System.out.println("esta = " + esta);

        Collection<Object> valores = persona.values();
        for (Object v : valores) {
            System.out.println("v = " + v);
        }
        for (Map.Entry<String, Object> par : persona.entrySet()) {
            System.out.println(par.getKey() + " => " + par.getValue());
        }


        System.out.println("======================================");
        for (String llave : persona.keySet()) {
            Object valor = persona.get(llave);
            System.out.println(llave + " => " + valor);
        }
        System.out.println("======================================");
        for (String llave : persona.keySet()) {
            Object valor = persona.get(llave);
            if (valor instanceof Map){
                String nom= (String) persona.get("nombre");
                Map<String,String>direccionMap=(Map<String, String>) valor;
                System.out.println("el pais de " +nom + ": " +
                        direccionMap.get("pais"));
                System.out.println("la ciudad de "+nom+": "+direccionMap.get("ciudad"));
            }else{
                System.out.println(llave + " => " + valor);
            }
        }


        Map<String, String> sacarDireccion = (Map<String, String>) persona.get("direccion");
        System.out.println("sacarDireccion = " + sacarDireccion);
        String pais = sacarDireccion.get("pais");
        String estado = sacarDireccion.get("estado");
        String ciudad = sacarDireccion.get("ciudad");
        String barrio = sacarDireccion.getOrDefault("barrio", "la playa");
        System.out.println("direcion de entrega: " + pais + estado + ciudad + barrio);
    }
}
