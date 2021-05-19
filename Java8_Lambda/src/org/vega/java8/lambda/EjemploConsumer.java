package org.vega.java8.lambda;

import org.vega.java8.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class EjemploConsumer {
    public static void main(String[] args) {

        Consumer<String> consumidor = saludo -> System.out.println(saludo);

        Consumer<Date> fechaaa = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        fechaaa.accept(new Date());


        BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
            System.out.println(nombre + ", tiene " + edad + " años");
        };
        consumidorBi.accept("pepe", 20);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("hola mundo lambda");

        List<String> nombres = Arrays.asList("andres", "pepe", "luz");
        nombres.forEach(consumidor2);

        Supplier<Usuario> crearUsuario = () -> new Usuario();

        Usuario usuario = crearUsuario.get();//new Usuario();


        BiConsumer<Usuario, String> asignarNombre = (persona, nombre) -> {
            persona.setNombre(nombre);
        };

        asignarNombre.accept(usuario, "pepito");
        System.out.println("nombre del usuario: " + usuario.getNombre());

        Supplier<String> proveedor = () -> {
            return "hola mundo desde un lambda supplier";
        };
        System.out.println(proveedor.get());

    }
}
