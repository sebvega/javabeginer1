package org.vega.patrones.factory.producto;

import org.vega.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {
    @Override
    public void cocinar() {
        System.out.println("cocinando por 20min a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando la pizz en rebanadas cuadradas");
    }

    public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza vegetariana California";
        masa = "masa integral ligth";
        salsa = "salsa de carnes";
        ingrediente.add("queso motzzarela");
        ingrediente.add("tomate");
        ingrediente.add("aceitunas");
        ingrediente.add("cebolla");
        ingrediente.add("berengenas");
    }
}
