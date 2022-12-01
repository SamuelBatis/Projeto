package GUI;

import dao.DaoFactory;
import dao.FuncionarioDao;
import dao.TelefoneDao;
import entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioFuncionarioGUI extends JFrame {

    FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();
    TelefoneDao telefoneDao = DaoFactory.createTelefoneDao();

    private Funcionario funcionario = new Funcionario();

    private JPanel painel;
    private JLabel lblNome;
    private JLabel lblEndereco;
    private JLabel lblPassword;
    private JLabel lblEmail;
    private JLabel lblCpf;
    private JLabel lblRg;
    private JLabel lblRegistroTecnico;
    private JLabel lblPosto;
    private JLabel lblCidade;
    private JLabel lblEstado;
    private JLabel lblProfissao;
    private JLabel lblTelefone;
    private JTextField txtNome;
    private JTextField txtEndereco;
    private JPasswordField txtPassword;
    private JTextField txtEmail;
    private JTextField txtCpf;
    private JTextField txtRg;
    private JTextField txtRegistroTecn;
    private JTextField txtTelefone;
    private JComboBox cbxPosto;
    private JComboBox<String>  cbxCidade;
    private JComboBox<String>  cbxEstado;
    private JComboBox<String>  cbxProfissao;

    private JButton btnRegistrar;


    void initializeGui() {

        this.painel = new JPanel();
        this.lblNome = new JLabel("Nome");
        this.lblEndereco = new JLabel("Endereço");
        this.lblEmail = new JLabel("Email");
        this.lblPassword =  new JLabel("Senha");
        this.lblCpf = new JLabel("Cpf");
        this.lblRg = new JLabel("Rg");
        this.lblRegistroTecnico = new JLabel("Registro Tecnico");
        this.lblPosto = new JLabel("Posto");
        this.lblCidade = new JLabel("Cidade");
        this.lblEstado = new JLabel("Estado");
        this.lblProfissao = new JLabel("Profissão");
        this.lblTelefone = new JLabel("Telefone");

        this.txtNome = new JTextField();
        this.txtEndereco = new JTextField();
        this.txtEmail = new JTextField();
        this.txtPassword = new JPasswordField();
        this.txtCpf = new JTextField();
        this.txtRg = new JTextField();
        this.txtRegistroTecn = new JTextField();
        this.txtTelefone = new JTextField();

        this.btnRegistrar = new JButton("Registrar");

        String postos[] = {"Médico", "Recepção", "Enfermeiro", "Paramédico"};
        String estados[] = {"SP", "RJ", "MG", "ES"};
        String cidades[] = {"SP", "RJ", "BH", "VT"};


        this.cbxPosto = new JComboBox(postos);
        // cbxPosto.addItemListener();
        this.cbxCidade = new JComboBox(cidades);
        this.cbxEstado = new JComboBox(estados);
        this.cbxProfissao = new JComboBox(postos);



        lblNome.setBounds(10, 0, 200, 20);
        lblEndereco.setBounds(10, 50, 200, 20);
        lblEmail.setBounds(10, 100, 200, 20);
        lblPassword.setBounds(10, 150, 200, 20);
        lblCpf.setBounds(10, 200, 200, 20);
        lblRg.setBounds(300, 0, 200, 20);
        lblRegistroTecnico.setBounds(300, 50, 200, 20);
        lblPosto.setBounds(300, 100, 200, 20);
        lblCidade.setBounds(300, 150, 200, 20);
        lblEstado.setBounds(300, 200, 200, 20);
        lblProfissao.setBounds(10, 250, 200, 20);
        lblTelefone.setBounds(300, 250, 200, 20);

        cbxProfissao.setBounds(10, 300, 200, 20);
        txtTelefone.setBounds(300, 270, 200, 20);


        txtNome.setBounds(10, 20, 200, 20);
        txtEndereco.setBounds(10, 70, 200, 20);
        txtEmail.setBounds(10, 120, 200, 20);
        txtPassword.setBounds(10, 170, 200, 20);
        txtCpf.setBounds(10, 220, 200, 20);
        txtRg.setBounds(300, 20, 200, 20);
        txtRegistroTecn.setBounds(300, 70, 200, 20);
        cbxPosto.setBounds(300, 120, 200, 20);
        cbxCidade.setBounds(300, 170, 200, 20);
        cbxEstado.setBounds(300, 220, 200, 20);
        cbxProfissao.setBounds(10, 270, 200, 20);

        btnRegistrar.setBounds(190, 350, 200, 20);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Posto posto = new Posto();
                Cidade cidade = new Cidade();
                Estado estado = new Estado();
                Profissao profissao = new Profissao();
                funcionario.setNomeCompleto(txtNome.getText());
                funcionario.setEndereco(txtEndereco.getText());
                funcionario.setEmail(txtEmail.getText());
                funcionario.setUserPassword(txtPassword.getText());
                funcionario.setCpf(txtCpf.getText());
                funcionario.setRg(txtRg.getText());
                funcionario.setRegistroTecnico(txtRegistroTecn.getText());
                if(cbxPosto.getSelectedItem().equals("Médico")) {
                    posto.setPostoId(1);
                } else if (cbxPosto.getSelectedItem().equals("Recepção")) {
                    posto.setPostoId(2);
                }else if (cbxPosto.getSelectedItem().equals("Enfermeiro")) {
                    posto.setPostoId(3);
                }else if (cbxPosto.getSelectedItem().equals("Paramédico")) {
                    posto.setPostoId(4);
                }
                if(cbxProfissao.getSelectedItem().equals("Médico")) {
                    profissao.setIdProfissao(1);
                } else if (cbxProfissao.getSelectedItem().equals("Recepção")) {
                    profissao.setIdProfissao(2);
                }else if (cbxProfissao.getSelectedItem().equals("Enfermeiro")) {
                    profissao.setIdProfissao(3);
                }else if (cbxProfissao.getSelectedItem().equals("Paramédico")) {
                    profissao.setIdProfissao(4);
                }
                // posto.setPostoId(1);
                estado.setEstadoId(1);
                cidade.setEstado_idEstado(estado);
                cidade.setIdCidade(1);

                //profissao.setIdProfissao(1);


                funcionario.setAdm("false");
                funcionario.setCidade(cidade);
                funcionario.setEstado(estado);
                funcionario.setProfissao(profissao);
                funcionario.setPosto(posto);
                funcionarioDao.insert(funcionario);
            }
        });


        painel.add(lblNome);
        painel.add(lblEndereco);
        painel.add(lblEmail);
        painel.add(lblPassword);
        painel.add(lblCpf);
        painel.add(lblRg);
        painel.add(lblRegistroTecnico);
        painel.add(lblPosto);
        painel.add(lblCidade);
        painel.add(lblEstado);
        painel.add(lblEndereco);
        painel.add(lblProfissao);
        painel.add(txtNome);
        painel.add(txtEndereco);
        painel.add(txtEmail);
        painel.add(txtPassword);
        painel.add(txtCpf);
        painel.add(txtRg);
        painel.add(txtRegistroTecn);
        painel.add(cbxProfissao);
        painel.add(cbxPosto);
        painel.add(cbxCidade);
        painel.add(cbxEstado);
        painel.add(btnRegistrar);
        painel.add(lblTelefone);
        painel.add(txtTelefone);




        this.painel.setLayout(null);
        this.setTitle("Funcionario Form");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.add(painel);
        this.setVisible(true);
    }

    FormularioFuncionarioGUI(){
        initializeGui();
    }

    public static void main(String[] args) {
        FormularioFuncionarioGUI funcionarioGUI = new FormularioFuncionarioGUI();
    }
}
