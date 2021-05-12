package org.vega.poointerfaces.repositorio;

import java.util.List;

public interface OrdenebleRepositorio<T> {
    List<T> listar(String campo, Direccion dir);
}
