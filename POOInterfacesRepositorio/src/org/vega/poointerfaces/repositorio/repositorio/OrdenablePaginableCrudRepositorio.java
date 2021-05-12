package org.vega.poointerfaces.repositorio.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenebleRepositorio<T>
        , PaginableRepositorio<T>
        , CrudRepositorio<T>
        , Contable{
}
