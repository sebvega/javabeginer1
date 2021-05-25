package org.vega.anotaciones.ejemplo;

import org.vega.anotaciones.ejemplo.models.Producto;
import org.vega.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto pro = new Producto();
        pro.setNombre("mesa de cafe");
        pro.setPrecio(1000L);
        pro.setFecha(LocalDate.now());

        //String json=JsonSerializador.convertirJson(pro);
        System.out.println("json = " + JsonSerializador.convertirJson(pro));
    }
}
