package dao;

import entities.Resultado;

public interface ResultadoDao {

    void insert(Resultado obj);
    void update(Resultado obj);
    void deleteById(Integer id);
    Resultado findById(Integer id);
}
