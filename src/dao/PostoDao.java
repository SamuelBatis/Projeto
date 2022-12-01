package dao;

import entities.Posto;

public interface PostoDao {

    void insert(Posto obj);
    void update(Posto obj);
    void deleteById(Integer id);
    Posto findById(Integer id);
}
