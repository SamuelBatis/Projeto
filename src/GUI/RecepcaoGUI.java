package GUI;

import dao.DaoFactory;
import dao.PacienteDao;
import entities.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecepcaoGUI extends JFrame {

  FormularioPaciente formularioPaciente = null;

  PacienteDao pacienteDao = DaoFactory.createPacienteDao();

  private JPanel painel;

  private JLabel lblTitulo;

  private JLabel lblBuscarPaciente;

  private JTextField buscarPaciente;

  private JButton btnCadastroPaciente;

  private JButton btnAlta;

  private JButton btnBuscar;

  private JTable pacientesTable;

  private List<Paciente> pacientes;

  TableModel tableModel;

  void inicializarGui() {

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

    this.tableModel = new DefaultTableModel(data, columnNames);

    this.painel = new JPanel();

    this.pacientesTable = new JTable(tableModel);
    this.pacientesTable.setBounds(10, 300, 950, 50);

    this.btnBuscar = new JButton("Buscar");
    this.btnBuscar.setBounds(10,250, 100, 20);
    this.btnCadastroPaciente = new JButton("Cadastrar Paciente");
    this.btnCadastroPaciente.setBounds(160, 250, 200, 20);
    this.btnAlta = new JButton("Alta");
    this.btnAlta.setBounds(370, 250, 100, 20);


    this.lblTitulo = new JLabel("Recepção" );
    this.lblTitulo.setFont(new Font("Roboto", 50, 50));
    this.lblBuscarPaciente = new JLabel("Buscar paciente");
    this.lblBuscarPaciente.setBounds(10, 170, 200, 20);

    this.buscarPaciente = new JTextField();
    this.buscarPaciente.setBounds(10, 200, 200, 20);

    this.btnCadastroPaciente.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        formularioPaciente = new FormularioPaciente();
        //formularioPaciente.inicializarGui();
      }
    });

    painel.add(lblTitulo);
    painel.add(buscarPaciente);
    painel.add(lblBuscarPaciente);
    painel.add(btnBuscar);
    painel.add(btnCadastroPaciente);
    painel.add(btnAlta);
    painel.add(pacientesTable);

    this.lblTitulo.setBounds(350, 10, 500, 100);
    this.painel.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1000,1000);
    this.add(painel);
    this.setVisible(true);
  }

  RecepcaoGUI(){
    inicializarGui();
  }

  public static void main(String[] args) {
    RecepcaoGUI janela = new RecepcaoGUI();
  }
}
