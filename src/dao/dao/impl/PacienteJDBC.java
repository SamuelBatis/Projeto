package dao.dao.impl;

import dao.PacienteDao;
import db.DB;
import db.DbException;
import entities.Cidade;
import entities.Estado;
import entities.Medicamentos;
import entities.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteJDBC implements PacienteDao {


    private Connection conn;

    public PacienteJDBC (Connection conn) {this.conn = conn;}

    @Override
    public void insert(Paciente obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO Paciente (nomePaciente, idadePaciente, emailPaciente, RgPaciente, CpfPaciente, Efermidade_idEfermidade, Cidade_idCidade, Cidade_Estado_idEstado, Medicamentos_idMedicamentos1) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            st.setString(1, obj.getNomeCompleto());
            st.setString(2, obj.getIdade());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getRg());
            st.setString(5, obj.getCpf());
            st.setInt(6, obj.getEfermidade().getEfermidadeId());
            st.setInt(7, obj.getCidade().getIdCidade());
            st.setInt(8, obj.getEstado().getEstadoId());
            st.setInt(9, obj.getMedicamentos().getMedicamentosId());
            System.out.println("entrou aqui");
            st.executeUpdate();
            // System.out.println("Paciente Registrado " + obj.getNomeCompleto());
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void update(Paciente obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE Paciente "
                    + "SET nomePaciente = ?, idadePaciente = ?, emailPaciente = ?, RgPaciente = ?, CpfPaciente = ?, Efermidade_idEfermidade = ?, Cidade_idCidade = ?, Cidade_Estado_idEstado = ?, Medicamentos_idMedicamentos = ?"
                    + "Where idPaciente = ?"
            );
            st.setString(1, obj.getNomeCompleto());
            st.setString(2, obj.getIdade());
            st.setString(3, obj.getEmail());
            st.setString(4, obj.getRg());
            st.setString(5, obj.getCpf());
            st.setInt(6, obj.getEfermidade().getEfermidadeId());
            st.setInt(7, obj.getCidade().getIdCidade());
            st.setInt(8, obj.getEstado().getEstadoId());
            st.setInt(9, obj.getMedicamentos().getMedicamentosId());
            st.setInt(10, obj.getId());

            int rows = st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM Paciente where idPaciente = ?");

            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Paciente findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "select * from Paciente left join Cidade on Paciente.Cidade_idCidade = Cidade.idCidade left join Estado on Estado.idEstado = Paciente.Cidade_Estado_idEstado left join Medicamentos on Medicamentos.idMedicamentos = Paciente.Medicamentos_idMedicamentos1 where Paciente.idPaciente = ?;"
            );

            st.setInt(1, id);
            rs = st.executeQuery();

            Paciente paciente = new Paciente();

            while (rs.next()) {
                Estado estado = new Estado();
                Cidade cidade = new Cidade();

                Medicamentos medicamentos = new Medicamentos();

                estado.setEstadoId(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nomeEstado"));
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nomeCidade"));
                medicamentos.setNome(rs.getString("nomeMedicamentos"));
                medicamentos.setMarca(rs.getString("marcaMedicamentos"));


                paciente.setNomeCompleto(rs.getString("nomePaciente"));
                paciente.setCidade(cidade);
                paciente.setEstado(estado);
                paciente.setMedicamentos(medicamentos);
                paciente.setCpf(rs.getString("CpfPaciente"));
                paciente.setRg(rs.getString("RgPaciente"));
                paciente.setIdade(rs.getString("idadePaciente"));
                paciente.setId(rs.getInt("idPaciente"));
            }
            return paciente;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Paciente> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "select * from Paciente left join Cidade on Paciente.Cidade_idCidade = Cidade.idCidade left join Estado on Estado.idEstado = Paciente.Cidade_Estado_idEstado left join Medicamentos on Medicamentos.idMedicamentos = Paciente.Medicamentos_idMedicamentos1;"
            );
            rs = st.executeQuery();

            List<Paciente> list = new ArrayList<>();
            while (rs.next()) {
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                Paciente paciente = new Paciente();
                Medicamentos medicamentos = new Medicamentos();

                estado.setEstadoId(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nomeEstado"));
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nomeCidade"));
                medicamentos.setNome(rs.getString("nomeMedicamentos"));
                medicamentos.setMarca(rs.getString("marcaMedicamentos"));


                paciente.setNomeCompleto(rs.getString("nomePaciente"));
                paciente.setCidade(cidade);
                paciente.setEstado(estado);
                paciente.setMedicamentos(medicamentos);
                paciente.setCpf(rs.getString("CpfPaciente"));
                paciente.setRg(rs.getString("RgPaciente"));
                paciente.setIdade(rs.getString("idadePaciente"));
                paciente.setId(rs.getInt("idPaciente"));
                list.add(paciente);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }}
