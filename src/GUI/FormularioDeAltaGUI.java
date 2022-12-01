package GUI;

import javax.swing.*;

public class FormularioDeAltaGUI extends JFrame {
    private JPanel painel;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton finalizarButton;

    FormularioDeAltaGUI() {
        setContentPane(painel);
        setTitle("Formulario medicamento");
        setSize(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        FormularioDeAltaGUI formularioDeAltaGUI = new FormularioDeAltaGUI();
    }
}
