package org.vega.patrones.factory;

import java.util.ArrayList;
import java.util.List;

abstract public class PizzaProducto {
    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingrediente;

    public PizzaProducto() {
        this.ingrediente=new ArrayList<>();
    }

    public void preparar(){
        System.out.println("preparando "+nombre);
        System.out.println("selecionando masa "+masa);
        System.out.println("esparciendo la sala"+salsa);
        System.out.println("agregando ingredientes: ");
        this.ingrediente.forEach(System.out::println);
    }

    abstract public void cocinar();

    abstract public void cortar();

    public void empaquetar(){
        System.out.println("empacando en caja para llevar");
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "PizzaProducto{" +
                "nombre='" + nombre + '\'' +
                ", masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingrediente=" + ingrediente +
                '}';
    }
}
