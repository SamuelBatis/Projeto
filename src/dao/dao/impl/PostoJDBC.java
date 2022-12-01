package dao.dao.impl;

import dao.PostoDao;
import db.DB;
import db.DbException;
import entities.Efermidade;
import entities.Posto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostoJDBC implements PostoDao {

    private Connection conn;

    public PostoJDBC (Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Posto obj) {
        PreparedStatement st = null;


        try {
            st = conn.prepareStatement("Insert Into Posto (nomePosto) values (?);");
            st.setString(1, obj.getNome());
            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Posto obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE Posto SET nomePosto = ? where idPosto = ?;");
            st.setString(1, obj.getNome());
            st.setInt(2, obj.getPostoId());

            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM Posto where idPosto = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Posto findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from Posto where idPosto = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            Posto posto = new Posto();

            while (rs.next()) {
                posto.setNome(rs.getString("nomePosto"));
                posto.setPostoId(rs.getInt("idPosto"));
            }
            return posto;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
