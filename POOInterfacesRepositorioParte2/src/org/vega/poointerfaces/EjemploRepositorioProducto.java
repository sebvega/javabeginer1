package org.vega.poointerfaces;

import org.vega.poointerfaces.modelo.Producto;
import org.vega.poointerfaces.repositorio.*;
import org.vega.poointerfaces.repositorio.list.*;
import org.vega.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.vega.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;


import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
            repo.crear(new Producto("pera", 2000.0));
            repo.crear(new Producto("manzana", 3000.0));
            repo.crear(new Producto("banano", 500.0));
            repo.crear(new Producto("flores", 12000.0));

            List<Producto> inventario = repo.listar();


            inventario.forEach(System.out::println);
            System.out.println("==========paginable=========");

            List<Producto> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);

            System.out.println("==========ordenable=========");
            List<Producto> proOrderASC = repo.listar("descripcion", Direccion.ASC);
            proOrderASC.forEach(System.out::println);

            System.out.println("==========actualizar=========");
            Producto appleActualizar = new Producto("manzana gala", 3500.0);
            appleActualizar.setId(1);

            repo.editar(appleActualizar);

            System.out.println(repo.porId(1));

            System.out.println("==========ordenable=========");
            List<Producto> proOrderDESC = repo.listar("precio", Direccion.DESC);
            proOrderDESC.forEach(System.out::println);

            System.out.println("total de elementos: " + repo.totalCount());
        } catch (LecturaAccesoDatoException e) {
            System.out.println("lade = " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatosException e) {
            System.out.println("ade = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
