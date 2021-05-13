package org.vega.poointerfaces.repositorio;

import org.vega.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.vega.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();

    T porId(Integer id) throws AccesoDatosException;

    void crear(T c) throws AccesoDatosException;

    void editar(T e) throws AccesoDatosException;

    void eliminar(Integer id) throws AccesoDatosException;
}
