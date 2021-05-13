package org.vega.poointerfaces.repositorio;

import org.vega.poointerfaces.modelo.BaseEntity;
import org.vega.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.vega.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

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
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if (id==null||id<=0){
            throw new LecturaAccesoDatoException("id invalido, debe ser > 0");
        }
        T c = null;
        for (T cli : this.dataSourse) {
            if (cli.getId().equals(id)) {
                c = cli;
                break;
            }
        }
        if (c==null){
            throw new LecturaAccesoDatoException("No existe este registro con id: "+id);
        }
        return c;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatosException {
        if (t==null){
            throw new EscrituraAccesoDatosException("error al insertar un objeto null");
        }
        this.dataSourse.add(t);
    }


    @Override
    public void eliminar(Integer id)throws LecturaAccesoDatoException {
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
