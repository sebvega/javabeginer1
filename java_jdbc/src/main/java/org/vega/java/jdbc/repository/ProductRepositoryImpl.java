package org.vega.java.jdbc.repository;

import org.vega.java.jdbc.models.Categoria;
import org.vega.java.jdbc.models.Producto;
import org.vega.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT pro.*, ca.nombre AS categoria " +
                     "FROM productos AS pro " +
                     "INNER JOIN categorias AS ca ON (pro.id_categoria=ca.id) ")) {

            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try (PreparedStatement stmt = getConnection()
                .prepareStatement("SELECT pro.*, ca.nombre AS categoria " +
                        "FROM productos AS pro " +
                        "INNER JOIN categorias AS ca ON(pro.id_categoria = ca.id)WHERE pro.id = ? ")) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sqlQ;
        if (producto.getId()!=null && producto.getId() > 0) {
            sqlQ = "UPDATE productos SET nombre=?, precio=?, id_categoria=? WHERE id=?";
        } else {
            sqlQ = "INSERT INTO productos (nombre, precio, id_categoria, fecha_registro) VALUES(? ,? ,? ,? )";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sqlQ)) {
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2, producto.getPrecio());
            stmt.setLong(3,producto.getCategoria().getId());

            if (producto.getId()!=null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId());

            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM productos WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("id_categoria"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);
        return p;
    }
}
