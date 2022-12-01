package GUI;

import dao.DaoFactory;
import dao.FuncionarioDao;
import dao.MedicamentosDao;
import dao.PacienteDao;
import entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FormularioPacienteGUI extends JFrame {


    FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();
    MedicamentosDao medicamentosDao = DaoFactory.createMedicamentosDao();

    PacienteDao pacienteDao = DaoFactory.createPacienteDao();

    Paciente paciente = new Paciente();

    String estados[] = {"SP", "RJ", "MG", "ES"};
    String cidades[] = {"SP", "RJ", "BH", "VT"};
    private JPanel painel;
    private JTextField nomePaciente;
    private JTextField idadePaciente;
    private JTextField emailPaciente;
    private JTextField rgPaciente;
    private JTextField cpfPaciente;
    private JComboBox cbxEfermidade;
    private JComboBox cbxCIdade = new JComboBox(cidades);
    private JComboBox cbxMedicamentos;
    private JButton enviarFormularioButton;

    private List<Medicamentos> medicamentos;




    public FormularioPacienteGUI() {

        medicamentos = medicamentosDao.findAll();

        for (Medicamentos obj : medicamentos) {
            cbxMedicamentos.addItem(obj.getNome());
        }

        setContentPane(painel);
        setTitle("Formulario paciente");
        setSize(500, 500);
        setVisible(true);
        enviarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Efermidade efermidade = new Efermidade();
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                paciente.setNomeCompleto(nomePaciente.getText());
                paciente.setIdade(idadePaciente.getText());
                paciente.setEmail(emailPaciente.getText());
                paciente.setRg(rgPaciente.getText());
                paciente.setCpf(cpfPaciente.getText());
                if(cbxEfermidade.getSelectedItem().toString().equals("Insuficiência renal")) {
                    efermidade.setNome(cbxEfermidade.getSelectedItem().toString());
                    efermidade.setEfermidadeId(2);
                    paciente.setEfermidade(efermidade);
                } else {
                    // efermidade.setNome(cbxEfermidade.getSelectedItem().toString());
                    efermidade.setEfermidadeId(1);
                    paciente.setEfermidade(efermidade);
                }
                if(cbxCIdade.getSelectedItem().toString().equals("SP")) {

                    estado.setNome("SP");
                    estado.setEstadoId(1);
                    cidade.setNome("SP");
                    cidade.setIdCidade(1);
                    cidade.setEstado_idEstado(estado);
                    paciente.setEstado(estado);
                    paciente.setCidade(cidade);
                } else if (cbxCIdade.getSelectedItem().toString().equals("RJ")) {
                    estado.setNome("RJ");
                    estado.setEstadoId(2);
                    cidade.setNome("RJ");
                    cidade.setIdCidade(2);
                    cidade.setEstado_idEstado(estado);
                    paciente.setEstado(estado);
                    paciente.setCidade(cidade);
                }else if (cbxCIdade.getSelectedItem().toString().equals("BH")) {
                    estado.setNome("MG");
                    estado.setEstadoId(3);
                    cidade.setNome("BH");
                    cidade.setIdCidade(3);
                    cidade.setEstado_idEstado(estado);
                    paciente.setEstado(estado);
                    paciente.setCidade(cidade);
                }else if (cbxCIdade.getSelectedItem().toString().equals("VT")) {
                    estado.setEstadoId(4);
                    cidade.setIdCidade(4);
                    cidade.setEstado_idEstado(estado);
                    paciente.setEstado(estado);
                    paciente.setCidade(cidade);
                } else {
                    estado.setNome("SP");
                    estado.setEstadoId(1);
                    cidade.setNome("SP");
                    cidade.setIdCidade(1);
                    cidade.setEstado_idEstado(estado);
                    paciente.setIdade(idadePaciente.getText());
                    paciente.setEstado(estado);
                    paciente.setCidade(cidade);
                }

                Medicamentos medicamentos1 = new Medicamentos();
                /*estado.setEstadoId(1);
                cidade.setIdCidade(1);
                efermidade.setEfermidadeId(1);*/
                paciente.setEfermidade(efermidade);
                paciente.setCidade(cidade);
                paciente.setEstado(estado);
                medicamentos1.setMedicamentosId(1);
                paciente.setMedicamentos(medicamentos1);
                pacienteDao.insert(paciente);

            }
        });
    }

    public static void main(String[] args) {
        FormularioPacienteGUI funcionarioGUI = new FormularioPacienteGUI();
    }

}
