package org.vega.api.stream.ejemplos.models;

public class Factura {

    private String descripcion;
    private Usuario userFactura;

    public Usuario getUserFactura() {
        return userFactura;
    }

    public void setUserFactura(Usuario userFactura) {
        this.userFactura = userFactura;
    }

    public Factura(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
