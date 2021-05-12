package org.vega.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio<T> extends OrdenebleRepositorio<T>
        , PaginableRepositorio<T>
        , CrudRepositorio<T>
        , Contable{
}
