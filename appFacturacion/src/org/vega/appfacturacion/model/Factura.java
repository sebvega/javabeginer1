package org.vega.appfacturacion.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private int id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] itemFactura;
    private int indiceItems;

    public static final int MAX_ITEMS = 20;

    private static int ultimoId;

//constructor


    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.itemFactura = new ItemFactura[MAX_ITEMS];
        this.id = ++ultimoId;
        this.fecha = new Date();
    }
//fin constructor

    //get and set
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
//fin get and set

    public ItemFactura[] getItemFactura() {
        return itemFactura;
    }


    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.itemFactura[indiceItems++] = item;
        }
    }

    public double calcularTotal() {

        double total = 0.0;
        for (int i=0;i<indiceItems;i++) {
            total += this.itemFactura[i].calcularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura N°: ");
        sb.append(id).
                append("\ncliente:\t")
                .append(this.cliente.getNombre())
                .append("\tNIT:\t")
                .append(this.cliente.getNit())
                .append("\nDescripcion")
                .append("\n")
                .append(this.descripcion)
                .append("\n");
        SimpleDateFormat df = new SimpleDateFormat("dd' de 'MMMM, yyyy");
        sb.append("Fecha de emisión: ").
                append(df.format(this.fecha))
                .append("\n#\tNombre\t$\tCant.\tTotal\n").
                append("\n\n");

        for (int i=0;i<indiceItems;i++){
            sb.append(this.itemFactura[i])
                    .append("\n");
        }
        sb.append("\nTotal")
                .append(calcularTotal());

        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
