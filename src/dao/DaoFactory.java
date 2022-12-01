package dao;

import dao.dao.impl.*;
import db.DB;

import java.sql.Connection;

public class DaoFactory {

    public static FuncionarioDao createFuncionarioDao() {
        return new FuncionarioJDBC(DB.getConnection());
    }
    public static PacienteDao createPacienteDao() { return new PacienteJDBC(DB.getConnection());}
    public static CidadeDao createCidadeDao() { return new CidadeJDBC(DB.getConnection());}
    public static EfermidadeDao createEfermidadeDao() { return new EfermidadeJDBC(DB.getConnection());}
    public static EstadoDao createEstadoDao() { return new EstadoJDBC(DB.getConnection());}
    public static MedicamentosDao createMedicamentosDao() { return new MedicamentosJDBC(DB.getConnection());}
    public static PostoDao createPostoDao() { return new PostoJDBC(DB.getConnection());}
    public static ProfissaoDao createProfissaoDao() { return new ProfissaoJDBC(DB.getConnection());}

    public static ConsultaDao createConsultaDao() {return new ConsultaJDBC(DB.getConnection());}
    public static ResultadoDao createResultadoDao() { return new ResultadoJDBC(DB.getConnection());}
    public static TelefoneDao createTelefoneDao() { return new TelefoneJDBC(DB.getConnection());}


}
