package org.vega.optional.ejemplo.repository;

import org.vega.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio <T> {

    Optional<Computador> filtrar(String nombre);


}
