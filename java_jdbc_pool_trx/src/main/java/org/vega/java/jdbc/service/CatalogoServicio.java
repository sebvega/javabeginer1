package org.vega.java.jdbc.service;

import com.google.protobuf.DescriptorProtos;
import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.repository.CategoriaRepositorioImpl;
import org.vega.java.jdbc.repository.ProductRepositoryImpl;
import org.vega.java.jdbc.repository.Repository;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoServicio implements Service {
    private Repository<Producto> productoRepository;
    private Repository<Categoria> categoriaRepository;

    public CatalogoServicio() {
        this.productoRepository = new ProductRepositoryImpl();
        this.categoriaRepository = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            productoRepository.setConn(connection);

            return productoRepository.listar();
        }

    }

    @Override
    public Producto porId(Long id) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            productoRepository.setConn(connection);
            return productoRepository.porId(id);
        }
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            productoRepository.setConn(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try {
                nuevoProducto = productoRepository.guardar(producto);

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
            return nuevoProducto;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                productoRepository.eliminar(id);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
            productoRepository.setConn(connection);
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            categoriaRepository.setConn(connection);
            return categoriaRepository.listar();
        }
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            categoriaRepository.setConn(connection);
            return categoriaRepository.porId(id);
        }
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            categoriaRepository.setConn(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try {
                nuevaCategoria = categoriaRepository.guardar(categoria);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
            return nuevaCategoria;
        }
    }

    @Override
    public Categoria eliminarCategoria(Long id) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            categoriaRepository.setConn(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                categoriaRepository.eliminar(id);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            categoriaRepository.setConn(connection);
            productoRepository.setConn(connection);
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                Categoria nuevaCategoria = categoriaRepository.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                productoRepository.guardar(producto);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }

        }
    }
}
