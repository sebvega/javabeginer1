package org.vega.api.stream.ejemplos;

import org.vega.api.stream.ejemplos.models.Factura;
import org.vega.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario u1=new Usuario("jhon","doe");
        Usuario u2=new Usuario("pepe","martinez");

        u1.addFactura(new Factura("compras de tecnologia"));
        u1.addFactura(new Factura("compra de flores"));


        u2.addFactura(new Factura("bicicleta"));
        u2.addFactura(new Factura("pc gamer 1 link"));

        List<Usuario>compras= Arrays.asList(u1,u2);

        compras.stream().flatMap(e->e.getFacturas().stream())
                .forEach(s-> System.out.println(s.getDescripcion()
                        .concat(" :cliente ")
                        .concat(s.getUserFactura().toString())));

        /*
        for (Usuario u:compras){
            for (Factura f:u.getFacturas()){
                System.out.println("u = " + u.getDescripcion());
            }
        }*/



    }
}
