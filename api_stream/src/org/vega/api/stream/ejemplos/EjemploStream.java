package org.vega.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        //Stream<String> nombres= Stream.of("pato","pepe","andres");
        //nombres.forEach(System.out::println);

       // String[] arr={"pato","pepe","andres"};
        // nombres= Arrays.stream(arr);
       // nombres.forEach(System.out::println);

        /*Stream<String> nombres=Stream.<String>builder()
                .add("pato")
                .add("pepe")
                .add("andres").build();
        nombres.forEach(System.out::println);

        */
        List<String> lista=new ArrayList<>();
        lista.add("pato");
        lista.add("pepe");
        lista.add("andres");

        Stream<String> nombres=lista.stream();
        nombres.forEach(System.out::println);
        lista.forEach(System.out::println);


    }
}
