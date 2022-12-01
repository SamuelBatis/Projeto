package dao.dao.impl;

import dao.EfermidadeDao;
import db.DB;
import db.DbException;
import entities.Efermidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EfermidadeJDBC implements EfermidadeDao {


    private Connection conn;

    public EfermidadeJDBC (Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Efermidade obj) {
        PreparedStatement st = null;


        try {
            st = conn.prepareStatement("Insert Into Efermidade (nomeEfermidade) values (?);");
            st.setString(1, obj.getNome());
            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Efermidade obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE Efermidade SET nomeEfermidade = ? where idEfermidade = ?;");
            st.setString(1, obj.getNome());
            st.setInt(2, obj.getEfermidadeId());

            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM Efermidade where idEfermidade = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Efermidade findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from Efermidade where idEfermidade = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            Efermidade efermidade = new Efermidade();

            while (rs.next()) {
                efermidade.setEfermidadeId(rs.getInt("idEfermidade"));
                efermidade.setNome(rs.getString("nomeEfermidade"));
            }
            return efermidade;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
