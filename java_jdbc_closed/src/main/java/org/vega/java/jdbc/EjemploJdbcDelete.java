package org.vega.java.jdbc;

import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.repository.ProductRepositoryImpl;
import org.vega.java.jdbc.repository.Repository;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        Repository<Producto> repository = new ProductRepositoryImpl();

        System.out.println("=============listar============");
        repository.listar().forEach(System.out::println);

        System.out.println("=============obtener por id============");
        System.out.println(repository.porId(2L));

        System.out.println("=============editar nuevo producto============");
        Producto producto = new Producto();
        producto.setId(3L);
        producto.setNombre("uvas moradas");
        producto.setPrecio(50);
        repository.guardar(producto);
        System.out.println("actualizado con exito");
        repository.listar().forEach(System.out::println);

        repository.eliminar(3L);
        System.out.println("eliminado con exito");
        repository.listar().forEach(System.out::println);

    }
}
