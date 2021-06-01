package org.vega.java.jdbc;

import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.repository.CategoriaRepositorioImpl;
import org.vega.java.jdbc.repository.ProductRepositoryImpl;
import org.vega.java.jdbc.repository.Repository;
import org.vega.java.jdbc.service.CatalogoServicio;
import org.vega.java.jdbc.service.Service;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
        System.out.println("=============listar============");
        Service service = new CatalogoServicio();
        service.listar().forEach(System.out::println);

        System.out.println("==============insertar nueva categoria===================");
        Categoria categoria = new Categoria();
        categoria.setNombre("pescado");


        System.out.println("=============insertar nuevo producto============");
        Producto producto = new Producto();
        producto.setNombre("roba lo");
        producto.setPrecio(50);
        producto.setFechaRegistro(new Date());
        producto.setSku("12345fr");
        service.guardarProductoConCategoria(producto, categoria);
        System.out.println("guardado con exito:" + producto.getId());
        service.listar().forEach(System.out::println);

    }
}

