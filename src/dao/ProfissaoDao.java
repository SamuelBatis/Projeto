package dao;

import entities.Profissao;

public interface ProfissaoDao {

    void insert(Profissao obj);
    void update(Profissao obj);
    void deleteById(Integer id);
    Profissao findById(Integer id);
}
