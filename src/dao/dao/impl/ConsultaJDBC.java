package dao.dao.impl;

import dao.ConsultaDao;
import db.DB;
import db.DbException;
import entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaJDBC implements ConsultaDao {

    private Connection conn;

    public ConsultaJDBC(Connection conn) {this.conn = conn;}


    @Override
    public void insert(Consulta obj) {
        PreparedStatement st =  null;

        try {
            st = conn.prepareStatement("INSERT INTO Consulta (localConsulta, Paciente_idPaciente, descricao)" +
                    "VALUES" + "(?, ?, ?)");
            st.setString(1, obj.getLocal());
            st.setInt(2, obj.getPacienteId());
            st.setString(3, obj.getDecricao());
            int rows = st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeConnection();
        }
    }

    @Override
    public void update(Consulta obj) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE Consulta SET local = ?, Paciente_idPaciente = ?, descricao = ?");
            st.setString(1, obj.getLocal());
            st.setInt(2, obj.getPaciente().getId());
            st.setString(3, obj.getDecricao());

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection();
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM Consulta where idConsulta = ?");

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection();
        }
    }

    @Override
    public Consulta findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement("Select * from Consulta left join Paciente on Paciente.idPaciente = Consulta.Paciente_idPaciente " +
                    "left join Cidade on Paciente.Cidade_idCidade = Cidade.idCidade left join Estado on Estado.idEstado = Paciente.Cidade_Estado_idEstado " +
                    "left join Medicamentos on Medicamentos.idMedicamentos = Paciente.Medicamentos_idMedicamentos1 where Consulta.idConsulta = ?");            st.setInt(1, id);
            rs = st.executeQuery();
            Consulta consulta = new Consulta();

            while (rs.next()) {
                Paciente paciente = new Paciente();
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


                consulta.setLocal(rs.getString("local"));
                consulta.setPaciente(paciente);
                consulta.setDecricao("descricao");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeConnection();
        }
        return null;
    }
}
