package org.vega.poointerfaces.modelo;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this==o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        BaseEntity bs = (BaseEntity) o;
        return Objects.equals(id, bs.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
