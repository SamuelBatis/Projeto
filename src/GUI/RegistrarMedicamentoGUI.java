package GUI;

import dao.DaoFactory;
import dao.MedicamentosDao;
import entities.Medicamentos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarMedicamentoGUI extends JFrame {

    MedicamentosDao medicamentosDao = DaoFactory.createMedicamentosDao();
    Medicamentos medicamentos = new Medicamentos();
    private JTextField textMarca;
    private JTextField textNome;
    private JButton registrarButton;
    private JLabel lblNomeMedicamento;
    private JLabel lblMarca;
    private JPanel painel;

    RegistrarMedicamentoGUI() {
        setContentPane(painel);
        setTitle("Formulario medicamento");
        setSize(500, 200);
        setVisible(true);
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                medicamentos.setNome(textNome.getText());
                medicamentos.setMarca(textMarca.getText());
                medicamentosDao.insert(medicamentos);
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        RegistrarMedicamentoGUI registrarMedicamentoGUI = new RegistrarMedicamentoGUI();
    }

}
