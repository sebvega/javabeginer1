package org.vega.poointerfaces.repositorio.list;

import org.vega.poointerfaces.repositorio.AbstractListRepositorio;
import org.vega.poointerfaces.repositorio.Direccion;
import org.vega.poointerfaces.modelo.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto p=porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }
//ordenar de mayor a menor y viseversa
    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSourse);

        listaOrdenada.sort(new Comparator<Producto>() {

            @Override
            public int compare(Producto a, Producto b) {
                int resultado = 0;
                if (dir==Direccion.ASC) {
                    resultado = this.ordenar(campo, a, b);
                } else if (dir==Direccion.DESC) {
                    resultado = this.ordenar(campo, b, a);
                }
                return resultado;
            }
            private int ordenar(String campo, Producto a, Producto b) {
                int resultado = 0;
                switch (campo) {
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
                    case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
                }
                return resultado;
            }
        });
        return listaOrdenada;
    }
}
