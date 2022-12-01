package GUI;

import dao.DaoFactory;
import dao.PacienteDao;
import entities.Paciente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPaciente extends JFrame {

    PacienteDao pacienteDao = DaoFactory.createPacienteDao();
    private Paciente paciente = new Paciente();
    private JPanel painel;
    private JLabel lblTitulo;
    private JLabel lblEmail;
    private JLabel lblNome;
    private JLabel lblIdade;
    private JLabel lblCpf;
    private JLabel lblMedico;
    private JLabel lblEfermidade;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtCpf;
    private JTextField txtEmail;
    private JTextField txtMedico;
    private JTextField txtEfermidade;
    private ButtonGroup sexoEmGrupo;
    private JRadioButton rdoMasculino;
    private JRadioButton rdoFeminino;
    private JButton btnSubmit;

    private JComboBox<String>  cbxCidade;
    private JComboBox<String>  cbxEstado;

    String estados[] = {"SP", "RJ", "MG", "ES"};
    String cidades[] = {"SP", "RJ", "BH", "VT"};



    void inicializarGui() {
        this.painel = new JPanel();
        this.sexoEmGrupo = new ButtonGroup();
        this.rdoFeminino = new JRadioButton("Feminino", false);
        this.rdoFeminino.setBounds(10, 280, 90, 25);
        this.rdoMasculino = new JRadioButton("Masculino", true);
        this.rdoMasculino.setBounds(100, 280, 100, 25);
        this.cbxCidade = new JComboBox(cidades);
        this.cbxEstado = new JComboBox(estados);
        cbxCidade.setBounds(300, 170, 200, 20);
        cbxEstado.setBounds(300, 220, 200, 20);

        this.sexoEmGrupo.add(rdoFeminino);
        this.sexoEmGrupo.add(rdoMasculino);

        this.txtNome = new JTextField();
        this.txtNome.setBounds(100, 60, 200, 20);
        this.txtIdade = new JTextField();
        this.txtIdade.setBounds(100, 100, 200,20);
        this.txtCpf = new JTextField();
        this.txtCpf.setBounds(100, 140, 200, 20);
        this.txtEmail = new JTextField();
        this.txtEmail.setBounds(100, 180, 200, 20);
        this.txtMedico = new JTextField();
        this.cbxEstado.setBounds(100, 220, 200, 20);
        this.txtEfermidade = new JTextField();
        this.cbxCidade.setBounds(100, 260, 200, 20);


        this.lblTitulo = new JLabel("Formulario de paciente");
        this.lblTitulo.setBounds(140, 5, 300, 50);
        this.lblNome = new JLabel("Nome");
        this.lblNome.setBounds(10, 60, 100, 20);
        this.lblIdade = new JLabel("idade");
        this.lblIdade.setBounds(10, 100, 100, 20);
        this.lblCpf = new JLabel("Cpf");
        this.lblCpf.setBounds(10, 140, 100, 20);
        this.lblEmail = new JLabel("Email");
        this.lblEmail.setBounds(10, 180, 100, 20);
        this.lblMedico = new JLabel("Cidade");
        this.lblMedico.setBounds(10, 220, 100, 20);
        this.lblEfermidade = new JLabel("Estado");
        this.lblEfermidade.setBounds(10, 260, 100, 20);



        this.btnSubmit = new JButton("Enviar");
        this.btnSubmit.setBounds(10, 310, 100, 25);
        this.btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paciente.setNomeCompleto(txtNome.getText());
                paciente.setIdade(txtIdade.getText());
                //paciente.setCidade(txtBairro.getText());
                //paciente.setEfermidade(txtEfermidade.getText());
                paciente.setMedico(txtMedico.getText());
                paciente.setCpf(txtCpf.getText());
                if(rdoFeminino.isSelected() == true) {
                    paciente.setSexo("Feminino");
                } else {
                    paciente.setSexo("Masculino");
                }
                pacienteDao.insert(paciente);
                // System.out.println("entrou " + txtIdade.getText());
            }
        });

        this.painel.add(lblTitulo);
        this.painel.add(lblNome);
        this.painel.add(lblIdade);
        this.painel.add(lblCpf);
        this.painel.add(lblEmail);
        this.painel.add(rdoFeminino);
        this.painel.add(rdoMasculino);
        this.painel.add(txtNome);
        this.painel.add(txtIdade);
        this.painel.add(txtCpf);
        this.painel.add(txtEmail);
        this.painel.add(btnSubmit);
        this.painel.add(lblMedico);
        this.painel.add(lblEfermidade);
        this.painel.add(txtMedico);
        this.painel.add(txtEfermidade);
        painel.add(cbxCidade);
        painel.add(cbxEstado);

        this.painel.setLayout(null);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(painel);
        this.setVisible(true);
    }

    FormularioPaciente() {inicializarGui();}

    public static void main(String[] args) {
        FormularioPaciente janela = new FormularioPaciente();
    }
}
