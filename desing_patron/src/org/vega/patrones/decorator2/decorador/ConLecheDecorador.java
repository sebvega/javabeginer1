package org.vega.patrones.decorator2.decorador;

import org.vega.patrones.decorator2.Configurable;

public class ConLecheDecorador extends CafeDecorador {
    public ConLecheDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 3.7F;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Leche";
    }
}
