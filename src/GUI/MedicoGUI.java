package GUI;

import dao.DaoFactory;
import dao.PacienteDao;
import entities.Paciente;

import javax.swing.*;
import java.util.List;

public class MedicoGUI extends JFrame {

    // PacienteDao pacienteDao = DaoFactory.createPacienteDao();
    private JPanel painel;
    private JComboBox comboBox;
    private JLabel lblNomePaciente;
    private JLabel lblConsulta;
    private JLabel lblMedicamentos;
    private JLabel lblExames;

    private JButton btnSubmit;

    private JTextField nomePaciente;

    private JTextArea consulta;
    private JTextArea medicamentos;
    private JTextArea exames;

    private List<Paciente> pacientes;

    void inicializarGUI() {

        //pacientes = pacienteDao.findAll();
        /*String[] names = new String[pacientes.size()];
        Integer[] ids = new Integer[pacientes.size()];
        int i = 0;
        for(Paciente obj : pacientes) {
            names[i] = obj.getNomeCompleto();
            ids[i] = obj.getId();
            System.out.println("id: " + obj.getId());
            System.out.println("name: " + obj.getNomeCompleto());
            i++;
        }*/

        this.lblConsulta = new JLabel("Descrição da consulta");
        this.lblExames = new JLabel("Exames");
        this.lblMedicamentos = new JLabel("Medicamentos");
        this.lblConsulta = new JLabel("Consulta");
        this.consulta = new JTextArea();
        this.exames = new JTextArea();
        this.medicamentos = new JTextArea();
        this.btnSubmit = new JButton("Enviar");

        //this.comboBox = new JComboBox(names);

        this.painel = new JPanel();
        this.lblNomePaciente = new JLabel("Nome paciente");
        this.nomePaciente = new JTextField();

        lblNomePaciente.setBounds(10, 10, 200, 20);
        nomePaciente.setBounds(10, 40, 200, 20);
        comboBox.setBounds(10, 40, 200, 20);


        lblMedicamentos.setBounds(10, 60, 200, 20);
        medicamentos.setBounds(10, 80, 470, 200);
        lblExames.setBounds(500, 60, 200, 20);
        exames.setBounds(500, 80, 470,200);
        lblConsulta.setBounds(10, 290, 200, 20);
        consulta.setBounds(10, 310, 960, 250);
        btnSubmit.setBounds(400, 600, 200, 20);


        this.painel.setLayout(null);
        painel.add(lblNomePaciente);
        // painel.add(comboBox);
        painel.add(medicamentos);
        painel.add(exames);
        painel.add(lblMedicamentos);
        painel.add(lblExames);
        painel.add(lblConsulta);
        painel.add(consulta);
        painel.add(btnSubmit);

        this.setTitle("Atendimento Médico");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,1000);
        this.add(painel);
        this.setVisible(true);
    }

    MedicoGUI() {inicializarGUI();}

    public static void main(String[] args) {
        MedicoGUI janela = new MedicoGUI();
    }


}
