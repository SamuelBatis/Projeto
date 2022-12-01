package GUI;

import entities.Funcionario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

    private Funcionario admin = null;
    private JPanel painel;
    private JLabel lblTitle;

    private JButton btnNovoFuncionario;

    void inicializarGui() {
        this.painel = new JPanel();
        this.lblTitle = new JLabel("Admin");
        this.btnNovoFuncionario = new JButton("Registrar funcionario");

        lblTitle.setBounds(230, 20, 200, 20);
        btnNovoFuncionario.setBounds(150, 250, 190, 30);

        btnNovoFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioPaciente formularioPaciente = new FormularioPaciente();
            }
        });

        painel.add(lblTitle);
        painel.add(btnNovoFuncionario);

        this.painel.setLayout(null);
        this.setTitle("Admin");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(painel);
        this.setVisible(true);
    }
    AdminGUI() {
        inicializarGui();
    }

    AdminGUI(Funcionario obj) {
        Funcionario funcionario = new Funcionario();
        funcionario = obj;
        System.out.println("entrou " + obj.getNomeCompleto());
        inicializarGui();

    }

    public static void main(String[] args) {
        AdminGUI adminGUI = new AdminGUI();
    }
}

