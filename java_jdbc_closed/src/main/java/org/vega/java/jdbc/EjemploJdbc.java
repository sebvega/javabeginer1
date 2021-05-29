package org.vega.java.jdbc;

import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.repository.ProductRepositoryImpl;
import org.vega.java.jdbc.repository.Repository;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

            Repository<Producto> repository=new ProductRepositoryImpl();

            System.out.println("=============listar============");
            repository.listar().forEach(System.out::println);

            System.out.println("=============obtener por id============");
            System.out.println(repository.porId(2L));

            System.out.println("=============insertar nuevo producto============");
            Producto producto=new Producto();
            producto.setNombre("Zukini");
            producto.setPrecio(30);
            producto.setFechaRegistro(new Date());

            Categoria categoria =new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);

            repository.guardar(producto);
            System.out.println("guardado con exito");
            repository.listar().forEach(System.out::println);

    }
}
