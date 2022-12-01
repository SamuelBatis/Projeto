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

public class MedicoGui extends JFrame {

    PacienteDao pacienteDao = DaoFactory.createPacienteDao();

    private List<Paciente> pacientes;

    Integer idPaciente;

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    private JPanel painel;
    private JButton novoPacienteButton;
    private JButton novoMedicamentoButton;
    private JTable table1;
    private JButton consultaButton;
    private JTextField textField1;
    private JButton buscarButton;

    MedicoGui () {

        pacientes = pacienteDao.findAll();
        String[][] data = new String[pacientes.size()][5];
        int i = 0;

        for (Paciente obj : pacientes) {
            data[i][0] = obj.getId().toString();
            data[i][1] = obj.getNomeCompleto();
            data[i][2] = obj.getIdade();
            data[i][3] = obj.getCidade().getNome();
            System.out.println(obj.getNomeCompleto());
            i++;
        }


        String[] columnNames = {"Id", "Name", "Idade", "Cidade"};

        TableModel tableModel= new DefaultTableModel(data, columnNames);


        table1.setModel(tableModel);
        setContentPane(painel);
        setTitle("Médico");
        setSize(600, 500);
        setVisible(true);
        novoPacienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioPacienteGUI formularioPacienteGUI = new FormularioPacienteGUI();
            }
        });
        novoMedicamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarMedicamentoGUI registrarMedicamentoGUI = new RegistrarMedicamentoGUI();
            }
        });
        consultaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaGui consultaGui = new ConsultaGui(idPaciente);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int convertido = Integer.parseInt(textField1.getText());
                setIdPaciente(convertido);
            }
        });
    }

    public static void main(String[] args) {
        MedicoGui medicoGui = new MedicoGui();
    }
}
