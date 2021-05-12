package org.vega.poointerfaces.repositorio.repositorio;

import org.vega.poointerfaces.repositorio.modelo.Cliente;

import java.util.List;

public interface OrdenebleRepositorio {
    List<Cliente> listar(String campo, Direccion dir);
}
