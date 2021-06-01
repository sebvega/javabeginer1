package org.vega.java.jdbc;

import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.repository.ProductRepositoryImpl;
import org.vega.java.jdbc.repository.Repository;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {


        try (Connection connection = ConexionBaseDatos.getInstance()) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                Repository<Producto> repository = new ProductRepositoryImpl();

                System.out.println("=============listar============");
                repository.listar().forEach(System.out::println);

                System.out.println("=============obtener por id============");
                System.out.println(repository.porId(2L));

                System.out.println("=============insertar nuevo producto============");
                Producto producto = new Producto();
                producto.setNombre("pepino");
                producto.setPrecio(80);
                producto.setFechaRegistro(new Date());
                producto.setSku("1234");

                Categoria categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);

                repository.guardar(producto);
                System.out.println("guardado con exito");


                System.out.println("=============editar nuevo producto============");
                producto = new Producto();
                producto.setId(4L);
                producto.setNombre("vaca bonita de lala");
                producto.setPrecio(550);
                producto.setSku("1234567");
                categoria = new Categoria();
                categoria.setId(3L);
                producto.setCategoria(categoria);
                repository.guardar(producto);
                System.out.println("actualizado con exito");
                repository.listar().forEach(System.out::println);

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        }
    }
}
