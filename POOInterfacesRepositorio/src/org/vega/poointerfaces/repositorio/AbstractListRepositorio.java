package org.vega.poointerfaces.repositorio;

import org.vega.poointerfaces.modelo.BaseEntity;

import java.util.*;

public abstract class AbstractListRepositorio<T extends BaseEntity> implements OrdenablePaginableCrudRepositorio<T> {


    protected List<T> dataSourse;

    public AbstractListRepositorio() {
        this.dataSourse = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSourse;
    }

    @Override
    public T porId(Integer id) {
        T c = null;
        for (T cli : this.dataSourse) {
            if (cli.getId().equals(id)) {
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public void crear(T t) {
        this.dataSourse.add(t);
    }


    @Override
    public void eliminar(Integer id) {
        this.dataSourse.remove(this.porId(id));
    }



    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSourse.subList(desde, hasta);
    }

    @Override
    public int totalCount() {
        return this.dataSourse.size();
    }
}
