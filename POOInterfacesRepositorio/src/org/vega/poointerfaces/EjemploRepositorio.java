package org.vega.poointerfaces;

import org.vega.poointerfaces.repositorio.Direccion;
import org.vega.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.vega.poointerfaces.modelo.Cliente;
import org.vega.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.vega.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatosExceptions;
import org.vega.poointerfaces.repositorio.list.ClienteListRepositorio;
import org.vega.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.vega.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("juan", "juanito"));
            repo.crear(new Cliente("luci", "lucinda"));
            repo.crear(new Cliente("paco", "paquito"));
            repo.crear(new Cliente("andres", "anduro"));

            List<Cliente> clientes = repo.listar();


            clientes.forEach(System.out::println);
            System.out.println("==========paginable=========");

            List<Cliente> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);

            System.out.println("==========ordenable=========");
            List<Cliente> cliOrderASC = repo.listar("nombre", Direccion.ASC);
            cliOrderASC.forEach(System.out::println);

            System.out.println("==========actualizar=========");
            Cliente juanActualizar = new Cliente("juancho", "jacinto");
            juanActualizar.setId(5);

            repo.editar(juanActualizar);

            System.out.println(repo.porId(1));

            System.out.println("==========ordenable=========");
            List<Cliente> cliOrderDESC = repo.listar("apellido", Direccion.DESC);
            cliOrderDESC.forEach(System.out::println);

            System.out.println("total de elementos: " + repo.totalCount());

        }catch (RegistroDuplicadoAccesoDatosExceptions e){
            System.out.println("Registro duplicado = " + e.getMessage());
            e.printStackTrace();

        }catch (LecturaAccesoDatoException e) {
            System.out.println("lectura = " + e.getMessage());
            e.printStackTrace();

        }catch (EscrituraAccesoDatosException e){
                System.out.println("escritura = " + e.getMessage());
                e.printStackTrace();

        }catch (AccesoDatosException e){
            System.out.println("ade = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
