package org.vega.patrones.factory;

import org.vega.patrones.factory.producto.PizzaNewYorkItaliana;
import org.vega.patrones.factory.producto.PizzaNewYorkVegetariana;
import org.vega.patrones.factory.producto.PizzaNewYorkPepperoni;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory {
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPepperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
        return producto;
    }

}
