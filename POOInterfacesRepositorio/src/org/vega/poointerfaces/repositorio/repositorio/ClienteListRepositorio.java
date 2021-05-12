package org.vega.poointerfaces.repositorio.repositorio;

import org.vega.poointerfaces.repositorio.CrudRepositorio;
import org.vega.poointerfaces.repositorio.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements CrudRepositorio, OrdenebleRepositorio, PaginableRepositorio {


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
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        Cliente c = this.porId(id);
        this.dataSourse.remove(c);
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        /*dataSourse.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
                int resultado=0;
                if (dir==Direccion.ASC){
                    switch (campo){
                        case "id"->
                                resultado=a.getId().compareTo(b.getId());
                        case "nombre"->
                                resultado=a.getNombre().compareTo(b.getNombre());
                        case "apellido"->
                                resultado=a.getApellido().compareTo(b.getApellido());
                    }
                }else if (dir==Direccion.DESC){
                    switch (campo){
                        case "id"->
                                resultado=b.getId().compareTo(a.getId());
                        case "nombre"->
                                resultado=b.getNombre().compareTo(a.getNombre());
                        case "apellido"->
                                resultado=b.getApellido().compareTo(a.getApellido());
                    }
                }
                return resultado;
            }
        });*/

        dataSourse.sort((a, b) -> {
                    int resultado = 0;
                    if (dir==Direccion.ASC) {
                        switch (campo) {
                            case "id" -> resultado = a.getId().compareTo(b.getId());
                            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                        }
                    } else if (dir==Direccion.DESC) {
                        switch (campo) {
                            case "id" -> resultado = b.getId().compareTo(a.getId());
                            case "nombre" -> resultado = b.getNombre().compareTo(a.getNombre());
                            case "apellido" -> resultado = b.getApellido().compareTo(a.getApellido());
                        }
                    }
                    return resultado;
                }
        );
        return this.dataSourse;

    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSourse.subList(desde,hasta);
    }
}
