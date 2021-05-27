package org.vega.patrones.decorator2.decorador;

import org.vega.patrones.decorator2.Configurable;

public class ConChocholateDecorador extends CafeDecorador {

    public ConChocholateDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase()+5F;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes()+", Chocolate";
    }
}
