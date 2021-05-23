package org.vega.optional.ejemplo;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {

        String nombre = "Andres";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println("opt.isPresent() = " + opt.isPresent());
        if (opt.isPresent()) {
            System.out.println("Hola " + opt.get());
        }
        //opt.ifPresent(s -> System.out.println("Hola " + s));
        opt.ifPresent(s -> System.out.println("Hola " + s));
        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println("opt = " + opt);
        System.out.println(opt.isPresent());
        System.out.println(opt.isEmpty());

        opt.ifPresentOrElse(t -> System.out.println("hola " + t),
                () -> System.out.println("no esta presente"));
        // es igual a
        if (opt.isPresent()){
            System.out.println("hola "+opt.get());
        }else {
            System.out.println("no esta presente");
        }

        Optional<String>optEmpty=Optional.empty();
        System.out.println("optEmpty = " + optEmpty);



    }
}
