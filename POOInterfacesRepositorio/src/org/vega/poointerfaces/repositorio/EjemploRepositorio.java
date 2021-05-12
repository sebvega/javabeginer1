package org.vega.poointerfaces.repositorio;

import org.vega.poointerfaces.repositorio.modelo.Cliente;
import org.vega.poointerfaces.repositorio.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("juan", "juanito"));
        repo.crear(new Cliente("luci","lucinda"));
        repo.crear(new Cliente("paco","paquito"));
        repo.crear(new Cliente("andres","anduro"));

        List<Cliente>clientes= repo.listar();


        clientes.forEach(System.out::println);
        System.out.println("==========paginable=========");

        List<Cliente> paginable=repo.listar(1,3);
        paginable.forEach(System.out::println);

        System.out.println("==========ordenable=========");
        List<Cliente> cliOrderASC=repo.listar("nombre",Direccion.ASC);
        cliOrderASC.forEach(System.out::println);

        System.out.println("==========actualizar=========");
        Cliente juanActualizar=new Cliente("juancho","jacinto");
        juanActualizar.setId(1);

        repo.editar(juanActualizar);

        System.out.println(repo.porId(1));

        System.out.println("==========ordenable=========");
        List<Cliente> cliOrderDESC=repo.listar("apellido",Direccion.DESC);
        cliOrderDESC.forEach(System.out::println);

        System.out.println("total de elementos: "+repo.totalCount());
    }
}
