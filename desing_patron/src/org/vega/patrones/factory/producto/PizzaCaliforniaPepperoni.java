package org.vega.patrones.factory.producto;

import org.vega.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {
    @Override
    public void cocinar() {
        System.out.println("concinando por 50min a 55°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando la pizza en rectangulos");
    }

    public PizzaCaliforniaPepperoni() {
        super();
        nombre="Pizza California Pepperoni";
        masa="masa vieja";
        salsa="pasta de remolacha";
        ingrediente.add("queso doble crema");
        ingrediente.add("aceitunas");
        ingrediente.add("jamon");
        ingrediente.add("chorizo");
        ingrediente.add("champiñones");
    }
}
