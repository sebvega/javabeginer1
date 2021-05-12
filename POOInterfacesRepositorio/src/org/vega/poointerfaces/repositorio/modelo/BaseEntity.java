package org.vega.poointerfaces.repositorio.modelo;

public class BaseEntity {
    protected Integer id;
    protected static int ultimoId;


    public BaseEntity() {
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
