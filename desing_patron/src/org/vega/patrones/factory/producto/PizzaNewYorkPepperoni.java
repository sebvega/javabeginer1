package org.vega.patrones.factory.producto;

import org.vega.patrones.factory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {
    public PizzaNewYorkPepperoni() {
        super();
        nombre="Pizza peperoni NewYork";
        masa="masa muyida";
        salsa="salsa de tomate";
        ingrediente.add("queso mozzarela");
        ingrediente.add("extra pepperoni");
        ingrediente.add("aceitunas");
    }

    @Override
    public void cocinar() {
        System.out.println("cocinando por 40 min a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando piza en 2 revanadas");
    }


}
