package org.vega.java.jdbc.repository;

import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Producto> {

    private Connection conn;

    public ProductRepositoryImpl() {
    }

    public ProductRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT pro.*, ca.nombre AS categoria " +
                     "FROM productos AS pro " +
                     "INNER JOIN categorias AS ca ON (pro.id_categoria=ca.id) ")) {

            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }

        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement stmt = conn
                .prepareStatement("SELECT pro.*, ca.nombre AS categoria " +
                        "FROM productos AS pro " +
                        "INNER JOIN categorias AS ca ON(pro.id_categoria = ca.id)WHERE pro.id = ? ")) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sqlQ;
        if (producto.getId()!=null && producto.getId() > 0) {
            sqlQ = "UPDATE productos SET nombre=?, precio=?, id_categoria=?,sku? WHERE id=?";
        } else {
            sqlQ = "INSERT INTO productos (nombre, precio, id_categoria, sku, fecha_registro) VALUES(?, ? ,? ,? ,? )";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sqlQ, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());

            if (producto.getId()!=null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());

            } else {
                stmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();
            if (producto.getId()==null) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        producto.setId(rs.getLong(1));
                    }

                }
            }

        }
        return producto;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        p.setSku(rs.getString("sku"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id_categoria"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
