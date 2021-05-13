package org.vega.poointerfaces.repositorio.list;

import org.vega.poointerfaces.modelo.Cliente;
import org.vega.poointerfaces.repositorio.AbstractListRepositorio;
import org.vega.poointerfaces.repositorio.Direccion;
import org.vega.poointerfaces.repositorio.excepciones.AccesoDatosException;

import java.util.*;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {


    @Override
    public void editar(Cliente cliente) throws AccesoDatosException {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {

    }


    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSourse);

        listaOrdenada.sort(new Comparator<Cliente>() {

            @Override
            public int compare(Cliente a, Cliente b) {
                int resultado = 0;
                if (dir==Direccion.ASC) {
                    resultado = this.ordenar(campo, a, b);
                } else if (dir==Direccion.DESC) {
                    resultado = this.ordenar(campo, b, a);
                }
                return resultado;
            }

            private int ordenar(String campo, Cliente a, Cliente b) {
                int resultado = 0;
                switch (campo) {
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                }
                return resultado;
            }
        });
        return listaOrdenada;
    }
}
