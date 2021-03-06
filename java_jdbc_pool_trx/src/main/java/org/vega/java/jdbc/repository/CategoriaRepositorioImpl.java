package org.vega.java.jdbc.repository;

import org.vega.java.jdbc.models.Categoria;

import java.sql.*;
import java.util.*;

public class CategoriaRepositorioImpl implements Repository<Categoria> {

    private Connection conn;

    public CategoriaRepositorioImpl() {
    }


    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categorias")) {
            while (rs.next()) {
                Categoria ca = crearCategoria(rs);
                categorias.add(ca);
            }
        }
        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT *FROM categorias AS c WHERE c.id=?")) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    categoria = crearCategoria(rs);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sqlQ = null;
        if (categoria.getId()!=null && categoria.getId() > 0) {
            sqlQ = "UPDATE categorias SET nombre=? WHERE id=?";
        } else {
            sqlQ = "INSERT INTO categorias(nombre) VALUES(?)";
        }
        try (PreparedStatement stmt = conn.prepareStatement(sqlQ, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoria.getNombre());
            if (categoria.getId()!=null && categoria.getId() > 0) {
                stmt.setLong(2, categoria.getId());
            }
            stmt.executeUpdate();
            if (categoria.getId()==null) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        categoria.setId(rs.getLong(1));
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {

        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM categorias WHERE id=?")) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private Categoria crearCategoria(ResultSet rs) throws SQLException {
        Categoria ca = new Categoria();
        ca.setId(rs.getLong("id"));
        ca.setNombre(rs.getString("nombre"));
        return ca;
    }
}
