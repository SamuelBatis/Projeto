package GUI;

import dao.ConsultaDao;
import dao.DaoFactory;
import entities.Consulta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConsultaGui extends JFrame {
    private JPanel painel;

    ConsultaDao consultaDao = DaoFactory.createConsultaDao();

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    private Integer idPaciente;
    private JTextField textLocal;
    private JTextArea textArea1;
    private JButton enviarButton;

    ConsultaGui() {
        setContentPane(painel);
        setTitle("Consulta");
        setSize(600, 500);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    ConsultaGui(Integer id) {
        Consulta consulta = new Consulta();
        setIdPaciente(id);
        setContentPane(painel);
        setTitle("Consulta");
        setSize(600, 500);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consulta.setDecricao(textArea1.getText());
                consulta.setPacienteId(id);
                consulta.setLocal(textLocal.getText());
                consultaDao.insert(consulta);
            }
        });
    }

    public static void main(String[] args) {
        ConsultaGui consultaGui = new ConsultaGui(1);
    }
}
