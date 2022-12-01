package dao.dao.impl;

import dao.FuncionarioDao;
import db.DB;
import db.DbException;
import entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class  FuncionarioJDBC implements FuncionarioDao {

    private Connection conn;

    public FuncionarioJDBC (Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Funcionario obj) {
        PreparedStatement st = null;
        System.out.println("entrou");
        try {
            st = conn.prepareStatement("Insert Into Funcionario (nomeFuncionario, emailFuncionario, CpfFuncionario, RgFuncionario, RegistroTecnico, Posto_idPosto, Adiministrador, Cidade_idCidade, Cidade_Estado_idEstado, profissao_idprofissao, funcionarioPassword) "
                    + "VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            st.setString(1, obj.getNomeCompleto());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getRg());
            st.setString(5, obj.getRegistroTecnico());
            st.setInt(6, obj.getPosto().getPostoId());
            st.setString(7, obj.getAdm());
            st.setInt(8, obj.getCidade().getIdCidade());
            st.setInt(9, obj.getEstado().getEstadoId());
            st.setInt(10, obj.getProfissao().getIdProfissao());
            st.setString(11, obj.getUserPassword());
            System.out.println("regitrado " + obj.getNomeCompleto());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public void update(Funcionario obj) {

        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE Funcionario "
                    + "SET nomeFuncionario = ?,  emailFuncionario = ?, CpfFuncionario = ?, RgFuncionario = ?, RegistroTecnico = ?, Posto_idPosto = ?, Adiministrador = ?, Cidade_idCidade = ?, Cidade_Estado_idEstado = ?, profissão_idprofissão = ?"
                    + "Where idFuncionario = ?"
            );

            st.setString(1, obj.getNomeCompleto());

            st.setString(2, obj.getEmail());
            st.setString(3, obj.getCpf());
            st.setString(4, obj.getRg());
            st.setString(5, obj.getRegistroTecnico());
            st.setInt(6, obj.getPosto().getPostoId());
            st.setString(7, obj.getAdm());
            st.setInt(8, obj.getCidade().getIdCidade());
            st.setInt(9, obj.getEstado().getEstadoId());
            st.setInt(10, obj.getProfissao().getIdProfissao());
            st.setInt(11, obj.getIdFuncionario());

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM Funcionario where idFuncionario = ?");

            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Funcionario findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Funcionario funcionario = new Funcionario();
        try {
            st = conn.prepareStatement("Select * from Funcionario left join Posto on Funcionario.Posto_idPosto = Posto.idPosto left join Cidade on Funcionario.Cidade_idCidade = Cidade.idCidade left join Estado on Estado.idEstado = Funcionario.Cidade_Estado_idEstado; left join profissao on profissao.idprofissao = Funcionario.profissao_idprofissao where idFuncionario=?");
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNomeCompleto(rs.getString("nomeFuncionario"));

                funcionario.setRg(rs.getString("RgFuncionario"));
                funcionario.setRegistroTecnico(rs.getString("RegistroTecnico"));
                funcionario.setEmail(rs.getString("emailFuncionario"));
                funcionario.setTelefones(rs.getString("telefone"));
                return funcionario;

            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }


    }

    public Boolean findByEmail(String email, String password) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("Select * from Funcionario where email=?");
            st.setString(1, email);
            rs = st.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Funcionario autentication(String email, String password) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("Select * from Funcionario left join Posto on Funcionario.Posto_idPosto = Posto.idPosto left join Cidade on Funcionario.Cidade_idCidade = Cidade.idCidade left join Estado on Estado.idEstado = Funcionario.Cidade_Estado_idEstado left join profissao on profissao_idprofissao = profissao.idprofissao where emailFuncionario = ?;");
            st.setString(1, email);
            rs = st.executeQuery();

            Funcionario funcionario = new Funcionario();

            while (rs.next()) {


                    Estado estado = new Estado();
                    Cidade cidade = new Cidade();
                    Profissao profissao = new Profissao();
                    Posto posto = new Posto();

                    estado.setEstadoId(rs.getInt("idEstado"));
                    estado.setNome(rs.getString("nomeEstado"));
                    cidade.setIdCidade(rs.getInt("idCidade"));
                    cidade.setNome(rs.getString("nomeCidade"));
                    profissao.setIdProfissao(rs.getInt("idprofissao"));
                    profissao.setNome(rs.getString("nomeProfissao"));
                    posto.setPostoId(rs.getInt("idPosto"));
                    posto.setNome(rs.getString("nomePosto"));

                    funcionario.setNomeCompleto(rs.getString("nomeFuncionario"));

                    funcionario.setEmail(rs.getString("emailFuncionario"));
                    funcionario.setCpf(rs.getString("CpfFuncionario"));
                    funcionario.setRg(rs.getString("RgFuncionario"));
                    funcionario.setRegistroTecnico(rs.getString("RegistroTecnico"));
                    funcionario.setPosto(posto);
                    funcionario.setAdm(rs.getString("Adiministrador"));
                    funcionario.setCidade(cidade);
                    funcionario.setEstado(estado);
                    funcionario.setProfissao(profissao);
                    System.out.println("entrou");


                return funcionario;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Funcionario> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("Select * from Funcionario left join Posto on Funcionario.Posto_idPosto = Posto.idPosto left join Cidade on Funcionario.Cidade_idCidade = Cidade.idCidade left join Estado on Estado.idEstado = Funcionario.Cidade_Estado_idEstado; left join profissao on profissao.idprofissao = Funcionario.profissão_idprofissão;");
            rs = st.executeQuery();

            List<Funcionario> list = new ArrayList<>();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                Estado estado = new Estado();
                Cidade cidade = new Cidade();
                Profissao profissao = new Profissao();
                Posto posto = new Posto();

                estado.setEstadoId(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nomeEstado"));
                cidade.setIdCidade(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nomeCidade"));
                profissao.setIdProfissao(rs.getInt("idprofissao"));
                profissao.setNome(rs.getString("nomeProfissao"));
                posto.setPostoId(rs.getInt("idPosto"));
                posto.setNome(rs.getString("nomePosto"));

                funcionario.setNomeCompleto(rs.getString("nomeFuncionario"));

                funcionario.setEmail(rs.getString("emailFuncionario"));
                funcionario.setCpf(rs.getString("CpfFuncionario"));
                funcionario.setRg(rs.getString("RgFuncionario"));
                funcionario.setRegistroTecnico(rs.getString("RegistroTecnico"));
                funcionario.setPosto(posto);
                funcionario.setAdm(rs.getString("Adiministrador"));
                funcionario.setCidade(cidade);
                funcionario.setEstado(estado);
                funcionario.setProfissao(profissao);
                list.add(funcionario);

            }

            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }
}
