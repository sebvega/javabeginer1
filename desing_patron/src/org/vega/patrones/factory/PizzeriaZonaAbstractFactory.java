package org.vega.patrones.factory;

abstract public class PizzeriaZonaAbstractFactory {

    public PizzaProducto ordenarPizza(String tipo) {
        PizzaProducto pizza = crearPiza(tipo);
        System.out.println("fabricando la pizza " + pizza.getNombre());
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return pizza;
    }

    abstract PizzaProducto crearPiza(String tipo);
}
