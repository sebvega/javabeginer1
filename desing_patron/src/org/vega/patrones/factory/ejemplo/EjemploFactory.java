package org.vega.patrones.factory.ejemplo;

import org.vega.patrones.factory.PizzaProducto;
import org.vega.patrones.factory.PizzeriaCaliforniaFactory;
import org.vega.patrones.factory.PizzeriaNewYorkFactory;
import org.vega.patrones.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {

        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizzaPedido =california.ordenarPizza("queso");
        System.out.println("Bruce ordena una pizza "+pizzaPedido.getNombre());

        pizzaPedido = ny.ordenarPizza("vegetariana");
        System.out.println("andres pidio una piza "+pizzaPedido.getNombre());

        pizzaPedido=ny.ordenarPizza("italiana");
        System.out.println("kiko pidio una pizza "+pizzaPedido.getNombre());

        pizzaPedido=california.ordenarPizza("pepperoni");
        System.out.println("laura pidio una pizza "+pizzaPedido.getNombre());

        System.out.println("pizzaPedido = " + pizzaPedido);
    }
}
