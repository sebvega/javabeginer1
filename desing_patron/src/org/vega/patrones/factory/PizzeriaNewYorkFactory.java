package org.vega.patrones.factory;

import org.vega.patrones.factory.producto.PizzaNewYorkItaliana;
import org.vega.patrones.factory.producto.PizzaNewYorkVegetariana;
import org.vega.patrones.factory.producto.PizzaNewyorkPeperoni;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory {
    @Override
    PizzaProducto crearPiza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo) {
            case "vegetariana":
                producto = new PizzaNewYorkVegetariana();
                break;
            case "peperoni":
                producto = new PizzaNewyorkPeperoni();
                break;
            case "italiana":
                producto = new PizzaNewYorkItaliana();
                break;
        }
        return null;
    }

}
