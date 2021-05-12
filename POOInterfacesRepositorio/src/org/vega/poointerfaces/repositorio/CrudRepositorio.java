package org.vega.poointerfaces.repositorio;

import org.vega.poointerfaces.repositorio.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> listar();

    Cliente porId(Integer id);

    void crear(Cliente cliente);

    void editar(Cliente cliente);

    void eliminar(Cliente cliente);
}
