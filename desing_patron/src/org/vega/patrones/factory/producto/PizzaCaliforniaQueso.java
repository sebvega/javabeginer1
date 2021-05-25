package org.vega.patrones.factory.producto;

import org.vega.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {
    @Override
    public void cocinar() {
        System.out.println("cocinando por 25min a 220°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando la pizza en pentagonos");
    }

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza de queso california";
        masa = "masa gruesa";
        salsa = "pasta de tomate";
        ingrediente.add("capa delgada de queso");
        ingrediente.add("aceitunas");
        ingrediente.add("jamon");
        ingrediente.add("chorizo");
        ingrediente.add("champiñones");
    }
}
