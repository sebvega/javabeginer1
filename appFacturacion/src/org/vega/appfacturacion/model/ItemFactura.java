package org.vega.appfacturacion.model;

public class ItemFactura {

    private int cantidad;
    private  Producto producto;

//constructor

    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

//fin constructor

//get and set
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
//fin get and set

    public double calcularImporte(){
        return this.cantidad*this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return producto +
                "\t" + cantidad+
                "\t" + calcularImporte();
    }
}
