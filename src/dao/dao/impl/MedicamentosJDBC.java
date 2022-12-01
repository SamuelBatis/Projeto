package dao.dao.impl;

import dao.MedicamentosDao;
import db.DB;
import db.DbException;
import entities.Medicamentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentosJDBC implements MedicamentosDao {

    private Connection conn;

    public MedicamentosJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Medicamentos obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("insert into Medicamentos (nomeMedicamentos, marcaMedicamentos) values (?, ?)");
            st.setString(1, obj.getNome());
            st.setString(2, obj.getMarca());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public List<Medicamentos> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("Select * from Medicamentos");
            rs = st.executeQuery();

            List<Medicamentos> list = new ArrayList<>();

            while(rs.next()) {
                Medicamentos medicamentos = new Medicamentos();
                medicamentos.setNome(rs.getString("nomeMedicamentos"));
                medicamentos.setMarca(rs.getString("marcaMedicamentos"));
                list.add(medicamentos);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Medicamentos obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Medicamentos findById(Integer id) {
        return null;
    }
}
