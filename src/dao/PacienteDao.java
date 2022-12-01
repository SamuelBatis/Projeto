package dao;
import entities.Paciente;

import java.util.List;

public interface PacienteDao {
    void insert(Paciente obj);
    void update(Paciente obj);
    void deleteById(Integer id);
    Paciente findById(Integer id);
    List<Paciente> findAll();
}
