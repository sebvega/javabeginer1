package org.vega.generics;

import org.vega.poointerfaces.repositorio.modelo.Cliente;
import org.vega.poointerfaces.repositorio.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenetics {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Andres", "Guzman"));
        clientes.add(new Cliente("Brandon", "Becerra"));

        Cliente andres = clientes.get(0);

        Cliente brandon = clientes.iterator().next();
        Cliente[] clientes1={new Cliente("Andres", "Guzman")
                ,new Cliente("Brandon", "Becerra")};

        Integer[] enteros=new Integer[]{1,2,3,4,5,6,7};

        List<Cliente> clientes2=fromArrayToList(clientes1);
        List<Integer> enteros2=fromArrayToList(enteros);
        clientes2.forEach(System.out::println);
        enteros2.forEach(System.out::println);
        System.out.println();
        List<String>nombres=fromArrayToList(new String[]{"andres","pepe"
                ,"luci","jhon"},enteros);
        nombres.forEach(System.out::println);

        List<ClientePremium>clientePremiums=fromArrayToList(new ClientePremium[]{new ClientePremium("paco","paquito")});

        imprimirClientes(clientes);
        imprimirClientes(clientes2);
        imprimirClientes(clientePremiums);

        System.out.println("maximo de 1,9,4"+maximo(1,9,4));
        System.out.println("maximo de: zanahoria, manzana, arandano"+maximo("zanahoria","manzana","arandano"));
    }

    public static <T> List<T> fromArrayToList(T[] cli) {
        return Arrays.asList(cli);
    }
    public static <T,G> List<T> fromArrayToList(T[] cli, G[] g) {
        for (G elemento:g){
            System.out.println(elemento);
        }
        return Arrays.asList(cli);
    }
    public static <T extends Number> List<T> fromArrayToList(T[] cli) {
        return Arrays.asList(cli);
    }

    public static <T extends Cliente & Comparable> List<T> fromArrayToList(T[] cli) {
        return Arrays.asList(cli);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public  static <T extends Comparable<T>>T maximo(T a, T b,T c){
        T max=a;
        if (b.compareTo(max)>0)
            max=b;
        if (c.compareTo(max)>0)
            max=c;
        return max;
    }
}
