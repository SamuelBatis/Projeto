package dao;

import entities.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    void insert(Funcionario obj);
    void update(Funcionario obj);
    void deleteById(Integer id);
    Funcionario findById(Integer id);
    List<Funcionario> findAll();

    Boolean findByEmail(String obj, String password);

    Funcionario autentication(String email, String password);
}
