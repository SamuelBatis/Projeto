package dao;

import entities.Efermidade;

public interface EfermidadeDao {

    void insert(Efermidade obj);
    void update(Efermidade obj);
    void deleteById(Integer id);
    Efermidade findById(Integer id);
}
