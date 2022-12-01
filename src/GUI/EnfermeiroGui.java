package GUI;

import dao.DaoFactory;
import dao.PacienteDao;
import entities.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EnfermeiroGui extends JFrame{

    PacienteDao pacienteDao = DaoFactory.createPacienteDao();
    private List<Paciente> pacientes;
    private JButton novoPacienteButton;
    private JTable table1;
    private JPanel painel;

    EnfermeiroGui() {
        pacientes = pacienteDao.findAll();
        String[][] data = new String[pacientes.size()][5];
        int i = 0;

        for (Paciente obj : pacientes) {
            data[i][0] = obj.getNomeCompleto();
            data[i][1] = obj.getIdade();
            data[i][2] = obj.getCidade().getNome();

            data[i][3] = obj.getMedicamentos().getNome();
            System.out.println(obj.getNomeCompleto());
            i++;
        }


        String[] columnNames = { "Name", "Idade", "Cidade", "Medicamentos"};

        TableModel tableModel= new DefaultTableModel(data, columnNames);


        table1.setModel(tableModel);
        setContentPane(painel);
        setTitle("Enfermeiro");
        setSize(600, 500);
        setVisible(true);
        novoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioPacienteGUI formularioPacienteGUI = new FormularioPacienteGUI();
            }
        });
    }

    public static void main(String[] args) {
        EnfermeiroGui enfermeiroGui = new EnfermeiroGui();
    }

}
