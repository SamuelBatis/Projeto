package dao.dao.impl;

import dao.ResultadoDao;
import entities.Resultado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ResultadoJDBC implements ResultadoDao {

    private Connection conn;

    public ResultadoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Resultado obj) {
        PreparedStatement st = null;
        ResultSet rs = null;

    }

    @Override
    public void update(Resultado obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Resultado findById(Integer id) {
        return null;
    }
}
