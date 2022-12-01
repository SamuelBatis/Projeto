package dao.dao.impl;

import dao.ProfissaoDao;
import db.DB;
import db.DbException;
import entities.Efermidade;
import entities.Profissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfissaoJDBC implements ProfissaoDao {

    private Connection conn;

    public ProfissaoJDBC (Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Profissao obj) {
        PreparedStatement st = null;


        try {
            st = conn.prepareStatement("Insert Into profissao (nomeProfissao) values (?);");
            st.setString(1, obj.getNome());
            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Profissao obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE profissao SET nomeProfissao = ? where idprofissao = ?;");
            st.setString(1, obj.getNome());
            st.setInt(2, obj.getIdProfissao());

            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM profissao where idprofissao = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Profissao findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from profissao where idprofissao = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            Profissao profissao = new Profissao();

            while (rs.next()) {
                profissao.setIdProfissao(rs.getInt("idprofissao"));
                profissao.setNome(rs.getString("nomeProfissao"));
            }
            return profissao;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
