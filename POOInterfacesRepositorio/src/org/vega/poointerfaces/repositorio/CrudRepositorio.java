package org.vega.poointerfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();

    T porId(Integer id);

    void crear(T c);

    void editar(T e);

    void eliminar(Integer id);
}
