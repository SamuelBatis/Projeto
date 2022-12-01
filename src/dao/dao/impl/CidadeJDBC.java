package dao.dao.impl;

import dao.CidadeDao;
import entities.Cidade;

import java.sql.Connection;

public class CidadeJDBC implements CidadeDao {

    private Connection conn;

    public CidadeJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Cidade obj) {

    }

    @Override
    public void update(Cidade obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Cidade findById(Integer id) {
        return null;
    }
}
