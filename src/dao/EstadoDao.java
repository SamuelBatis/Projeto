package dao;

import entities.Estado;

public interface EstadoDao {

    void insert(Estado obj);
    void update(Estado obj);
    void deleteById(Integer id);
    Estado findById(Integer id);
}
