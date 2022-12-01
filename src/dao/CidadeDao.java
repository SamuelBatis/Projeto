package dao;

import entities.Cidade;

public interface CidadeDao {

    void insert(Cidade obj);
    void update(Cidade obj);
    void deleteById(Integer id);
    Cidade findById(Integer id);
}
