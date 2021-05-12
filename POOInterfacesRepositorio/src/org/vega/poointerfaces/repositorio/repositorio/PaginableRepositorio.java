package org.vega.poointerfaces.repositorio.repositorio;

import org.vega.poointerfaces.repositorio.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
