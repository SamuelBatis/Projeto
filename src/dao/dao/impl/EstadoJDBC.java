package dao.dao.impl;

import dao.EstadoDao;
import entities.Estado;

import java.sql.Connection;

public class EstadoJDBC implements EstadoDao {

    private Connection conn;

    public EstadoJDBC (Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Estado obj) {

    }

    @Override
    public void update(Estado obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Estado findById(Integer id) {
        return null;
    }
}
