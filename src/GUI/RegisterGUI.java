package GUI;

import dao.DaoFactory;
import dao.FuncionarioDao;
import entities.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class RegisterGUI extends JFrame {

    FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

    private JLabel lblMensagem;
    private Connection conn;
    private JPanel meuPainel;
    private JTextField caixaDeTexto;
    private Funcionario funcionario = new Funcionario();
    private JTextField nome;
    private JTextField email;
    private JTextField cpf;
    private JTextField rg;
    private JTextField telefone;
    private JTextField especialidade;
    private JTextField registroTecnico;
    private JTextField carteiraDeTrabalho;

    private JPasswordField userPassword;

    private JComboBox userFuncao;


    private JLabel lblResposta;
    private JLabel lblEmail;
    private JLabel lblCpf;
    private JLabel lblTelefone;
    private JLabel lblRg;
    private JLabel lblEspecialidade;
    private JLabel lblRegistroTecnico;
    private JLabel lblCarteiraDeTrabalho;
    private JLabel lblUserPassword;
    private JLabel lblUserFuncao;
    private JButton btnOk;

    private String funcaos[] = {"Médico", "Enfermeiro", "Recepcionista"};
    void inicializarGui(){
        this.meuPainel = new JPanel();
        this.nome = new JTextField();
        this.email = new JTextField();
        this.cpf = new JTextField();
        this.telefone = new JTextField();
        this.rg = new JTextField();
        this.especialidade = new JTextField();
        this.registroTecnico = new JTextField();
        this.carteiraDeTrabalho = new JTextField();
        this.userPassword = new JPasswordField();
        this.userFuncao = new JComboBox(funcaos);


        this.nome.setBounds(10, 50, 200, 20);
        this.email.setBounds(10, 90, 200, 20);
        this.cpf.setBounds(10, 130, 200, 20);
        this.telefone.setBounds(10, 170, 200, 20);
        this.userPassword.setBounds(10, 210, 200, 20);
        this.rg.setBounds(250, 50, 200, 20);
        this.especialidade.setBounds(250, 90, 200, 20);
        this.registroTecnico.setBounds(250, 130, 200, 20);
        this.carteiraDeTrabalho.setBounds(250, 170, 200, 20);
        this.userFuncao.setBounds(250, 210, 200, 20);

        this.lblResposta = new JLabel("Nome");
        this.lblResposta.setBounds(10, 30, 100, 20);
        this.lblEmail = new JLabel("Email");
        this.lblEmail.setBounds(10, 70, 100, 20);
        this.lblCpf = new JLabel("Cpf");
        this.lblCpf.setBounds(10, 110, 100, 20);
        this.lblTelefone = new JLabel("Telefone");
        this.lblTelefone.setBounds(10, 150, 100, 20);
        this.lblUserPassword = new JLabel("Password");
        this.lblUserPassword.setBounds(10, 190, 200, 20);
        this.lblRg = new JLabel("Rg");
        this.lblRg.setBounds(250, 30, 100, 20);
        this.lblEspecialidade = new JLabel("Especialidade");
        this.lblEspecialidade.setBounds(250, 70, 100, 20);
        this.lblRegistroTecnico = new JLabel("Registro Tecnico");
        this.lblRegistroTecnico.setBounds(250, 110, 200, 20);
        this.lblCarteiraDeTrabalho = new JLabel("Carteira de trabalho");
        this.lblCarteiraDeTrabalho.setBounds(250, 150, 200, 20);
        this.lblUserFuncao = new JLabel("Função");
        this.lblUserFuncao.setBounds(250, 190, 200, 20);


        this.btnOk = new JButton("Registrar");
        this.btnOk.setBounds(10, 250, 100, 20);
        this.btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                funcionario.setNomeCompleto(nome.getText());
                funcionario.setEmail(email.getText());
                funcionario.setCpf(cpf.getText());
                funcionario.setRg(rg.getText());
                funcionario.setTelefones(telefone.getText());
                funcionario.setEspecilidade(especialidade.getText());
                funcionario.setRegistroTecnico(registroTecnico.getText());
                funcionario.setCarteiraDeTrabalho(carteiraDeTrabalho.getText());
                funcionario.setUserPassword(userPassword.getText());
                funcionario.setFuncao(userFuncao.getSelectedItem().toString());
                // System.out.println("nome: " + funcionario.getNomeCompleto() + funcionario.getFuncao());
                funcionarioDao.insert(funcionario);
            }
        });
        this.meuPainel.setLayout(null);
        meuPainel.add(btnOk);
        meuPainel.add(lblResposta);
        meuPainel.add(lblEmail);
        meuPainel.add(lblCpf);
        meuPainel.add(lblTelefone);
        meuPainel.add(lblRg);
        meuPainel.add(lblEspecialidade);
        meuPainel.add(lblRegistroTecnico);
        meuPainel.add(lblCarteiraDeTrabalho);
        meuPainel.add(nome);
        meuPainel.add(email);
        meuPainel.add(cpf);
        meuPainel.add(telefone);
        meuPainel.add(rg);
        meuPainel.add(especialidade);
        meuPainel.add(registroTecnico);
        meuPainel.add(carteiraDeTrabalho);
        meuPainel.add(userPassword);
        meuPainel.add(userFuncao);
        meuPainel.add(lblUserPassword);
        meuPainel.add(lblUserFuncao);

        this.setTitle("Formulario de registro");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(meuPainel);
        this.setVisible(true);
    }

    RegisterGUI(){
        inicializarGui();
    }

    RegisterGUI(Funcionario funcionario) {
        this.funcionario = funcionario;
        inicializarGui();
    }

    public RegisterGUI(Connection conn) {
        this.conn = conn;
        this.funcionario = new Funcionario();
        inicializarGui();
    }


    public static void main(String[] args) {
        RegisterGUI janela = new RegisterGUI();
    }
}
