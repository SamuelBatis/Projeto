package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGui extends JFrame{
    private JButton registrarFuncionarioButton;
    private JButton médicoButton;
    private JButton recepçãoButton;
    private JButton enfermeiroButton;
    private JButton paramédicoButton;
    private JPanel painel;

    AdminGui() {
        setContentPane(painel);
        setTitle("Admin");
        setSize(600, 500);
        setVisible(true);
        registrarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioFuncionarioGUI formularioFuncionarioGUI = new FormularioFuncionarioGUI();
            }
        });
        médicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MedicoGui recepcaoGui = new MedicoGui();
            }
        });
        recepçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RecepcaoGui recepcaoGui = new RecepcaoGui();
            }
        });
        enfermeiroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnfermeiroGui enfermeiroGui = new EnfermeiroGui();
            }
        });
        paramédicoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ParamedicoGui paramedicoGui = new ParamedicoGui();
            }
        });
    }

    public static void main(String[] args) {
        AdminGui adminGui = new AdminGui();
    }
}
