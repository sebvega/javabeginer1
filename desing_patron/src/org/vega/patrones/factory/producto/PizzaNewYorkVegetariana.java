package org.vega.patrones.factory.producto;

import org.vega.patrones.factory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {

    public PizzaNewYorkVegetariana() {
        super();
        nombre = "Pizza vegetariana NewYork";
        masa = "masa integral vegana";
        salsa = "salsa de carnes";
        ingrediente.add("queso vegano");
        ingrediente.add("tomate");
        ingrediente.add("aceitunas");
        ingrediente.add("espinacas");
        ingrediente.add("berengenas");
    }

    @Override
    public void cocinar() {
        System.out.println("cocinando por 25 minutos a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando la pizza en 8 porciones");
    }
}
