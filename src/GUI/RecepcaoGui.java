package GUI;

import dao.DaoFactory;
import dao.PacienteDao;
import entities.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RecepcaoGui extends JFrame {

    PacienteDao pacienteDao = DaoFactory.createPacienteDao();
    private List<Paciente> pacientes;


    private JButton cadastrarPacienteButton;
    private JTable table1;
    private JPanel painel;
    private JButton registrarMedicamentoButton;

    public RecepcaoGui() {
        pacientes = pacienteDao.findAll();
        String[][] data = new String[pacientes.size()][5];
        int i = 0;

        for (Paciente obj : pacientes) {
            data[i][0] = obj.getNomeCompleto();
            data[i][1] = obj.getIdade();
            data[i][2] = obj.getCidade().getNome();

            data[i][4] = obj.getCpf();
            System.out.println(obj.getNomeCompleto());
            i++;
        }


        String[] columnNames = { "Name", "Idade", "Cidade"};

        TableModel tableModel= new DefaultTableModel(data, columnNames);


        table1.setModel(tableModel);



        setContentPane(painel);
        setTitle("Formulario paciente");
        setSize(500, 500);
        setVisible(true);
        cadastrarPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioPacienteGUI formularioPacienteGUI = new FormularioPacienteGUI();
            }
        });
        registrarMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarMedicamentoGUI registrarMedicamentoGUI = new RegistrarMedicamentoGUI();
            }
        });
    }

    public static void main(String[] args) {
        RecepcaoGui recepcaoGui = new RecepcaoGui();
    }
}
