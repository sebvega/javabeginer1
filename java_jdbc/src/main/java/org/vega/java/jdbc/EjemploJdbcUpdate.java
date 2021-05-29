package org.vega.java.jdbc;

import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.repository.ProductRepositoryImpl;
import org.vega.java.jdbc.repository.Repository;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {


        try (Connection connection = ConexionBaseDatos.getInstance()){

            Repository<Producto> repository=new ProductRepositoryImpl();

            System.out.println("=============listar============");
            repository.listar().forEach(System.out::println);

            System.out.println("=============obtener por id============");
            System.out.println(repository.porId(2L));

            System.out.println("=============editar nuevo producto============");
            Producto producto=new Producto();
            producto.setId(4L);
            producto.setNombre("vaca bonita");
            producto.setPrecio(50);
            Categoria categoria=new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repository.guardar(producto);
            System.out.println("actualizado con exito");
            repository.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
