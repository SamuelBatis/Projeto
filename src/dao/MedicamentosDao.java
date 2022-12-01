package dao;

import entities.Medicamentos;

import java.util.List;

public interface MedicamentosDao {

    void insert(Medicamentos obj);
    void update(Medicamentos obj);
    void deleteById(Integer id);
    Medicamentos findById(Integer id);
    List<Medicamentos> findAll();
}
