package dao.dao.impl;

import dao.TelefoneDao;
import db.DB;
import db.DbException;
import entities.Efermidade;
import entities.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelefoneJDBC implements TelefoneDao {

    private Connection conn;

    public TelefoneJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Telefone obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("Insert Into telefone (telefone, Funcionario_idFuncionario, Paciente_idPaciente) values (?, ?, ?);");
            st.setString(1, obj.getTelefone());
            st.setInt(2, obj.getIdFuncionario());
            st.setInt(3, obj.getIdPaciente());
            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void update(Telefone obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE telefone SET telefone = ?, Funcionario_idFuncionario = ?, Paciente_idPaciente = ? where idtelefone = ?;");
            st.setString(1, obj.getTelefone());
            st.setInt(2, obj.getIdFuncionario());
            st.setInt(3, obj.getIdPaciente());
            st.setInt(4, obj.getIdTelefone());

            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM telefone where idtelefone = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Telefone findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("select * from telefone where idtelefone = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            Telefone telefone = new Telefone();

            while (rs.next()) {
                telefone.setIdTelefone(rs.getInt("idtelefone"));
                telefone.setTelefone(rs.getString("telefone"));
                telefone.setIdPaciente(rs.getInt("Funcionario_idFuncionario"));
                telefone.setIdFuncionario(rs.getInt("Paciente_idPaciente"));
            }
            return telefone;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
}
