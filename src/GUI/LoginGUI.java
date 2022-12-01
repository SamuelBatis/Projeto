package GUI;

import dao.DaoFactory;
import dao.FuncionarioDao;
import dao.dao.impl.FuncionarioJDBC;
import entities.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    FuncionarioDao funcionarioDao = DaoFactory.createFuncionarioDao();

    Funcionario funcionario = null;

    private JPanel painel;

    private JLabel password;

    private JLabel user;

    private JTextField userField;

    private JPasswordField passwordField;

    private JButton loginButton;

    void inicializarGui() {
        this.painel = new JPanel();
        this.user = new JLabel("Email");
        this.password = new JLabel("Password");
        this.userField = new JTextField();
        this.passwordField = new JPasswordField();
        this.loginButton = new JButton("Login");

        this.user.setBounds(50, 50, 200, 20);
        this.password.setBounds(50, 100, 200, 20);
        this.userField.setBounds(50, 75, 200, 20);
        this.passwordField.setBounds(50, 125, 200, 20);
        this.loginButton.setBounds(50, 175, 150, 20);

        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionario = funcionarioDao.autentication(userField.getText(), passwordField.getText());
                System.out.println("adm? " + funcionario.getAdm() + ",");
                if(funcionario.getAdm().equals("true")) {
                    System.out.println("entrou aqui");
                    AdminGui adminGUI = new AdminGui();
                    // adminGUI.inicializarGui();
                } else if(funcionario.getProfissao().getNome().equals("Medico")) {
                    MedicoGui medicoGui = new MedicoGui();
                } else if(funcionario.getProfissao().getNome().equals("Recepção")) {
                    RecepcaoGui recepcaoGui = new RecepcaoGui();
                }else if(funcionario.getProfissao().getNome().equals("Enfermeiro")) {
                    EnfermeiroGui recepcaoGui = new EnfermeiroGui();
                } else if(funcionario.getProfissao().getNome().equals("Paramédico")) {
                    ParamedicoGui recepcaoGui = new ParamedicoGui();
                }

                else {
                    System.out.println(funcionario.getProfissao().getNome());
                }
                System.out.println("Encontrou o usuario: " + funcionario.getNomeCompleto());
            }
        });


        painel.add(user);
        painel.add(password);
        painel.add(userField);
        painel.add(passwordField);
        painel.add(loginButton);


        this.painel.setLayout(null);
        this.setTitle("Login form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(painel);
        this.setVisible(true);

    }

    public LoginGUI() {inicializarGui();}

    public static void main(String[] args) {
        LoginGUI janela = new LoginGUI();
    }


}
