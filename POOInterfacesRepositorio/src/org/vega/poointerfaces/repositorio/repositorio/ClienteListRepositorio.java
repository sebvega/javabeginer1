package org.vega.poointerfaces.repositorio.repositorio;


import org.vega.poointerfaces.repositorio.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements OrdenablePaginableCrudRepositorio {


    private List<Cliente> dataSourse;

    public ClienteListRepositorio() {
        this.dataSourse = new ArrayList<>();
    }

    @Override
    public List<Cliente> listar() {
        return this.dataSourse;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente c = null;
        for (Cliente cli : this.dataSourse) {
            if (cli.getId().equals(id)) {
                c = cli;
                break;
            }
        }
        return c;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSourse.add(cliente);
    }

    @Override
    public void editar(Cliente clienteAct) {
        Cliente c = this.porId(clienteAct.getId());
        c.setNombre(clienteAct.getNombre());
        c.setApellido(clienteAct.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        this.dataSourse.remove(c);
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

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSourse.subList(desde, hasta);
    }

    @Override
    public int totalCount() {
        return this.dataSourse.size();
    }
}
