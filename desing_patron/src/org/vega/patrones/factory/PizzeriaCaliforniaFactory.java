package org.vega.patrones.factory;

import org.vega.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.vega.patrones.factory.producto.PizzaCaliforniaQueso;
import org.vega.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory {
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = switch (tipo) {
            case "queso" -> new PizzaCaliforniaQueso();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "vegetariana" -> new PizzaCaliforniaVegetariana();
            default -> null;
        };
        return producto;
    }
}
