package org.vega.patrones.factory.producto;

import org.vega.patrones.factory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {
    public PizzaNewYorkItaliana() {
        super();
        nombre="Pizza Italiana NewYork";
        masa = "masa gruesa";
        salsa = "pasta de tomate";
        ingrediente.add("queso doble crema");
        ingrediente.add("aceitunas");
        ingrediente.add("jamon");
        ingrediente.add("chorizo");
        ingrediente.add("champiñones");
    }

    @Override
    public void cocinar() {
        System.out.println("cocinanco la pizza por 30min a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando la piza en diagonal");
    }
}
