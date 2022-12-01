package GUI;

import dao.DaoFactory;
import dao.EfermidadeDao;
import entities.Efermidade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EfermidadeGui extends JFrame {

    EfermidadeDao efermidadeDao = DaoFactory.createEfermidadeDao();

    Efermidade efermidade = new Efermidade();
    private JTextField textNomeEfermidade;
    private JButton enviarButton;
    private JPanel painel;

    public EfermidadeGui() {
        setContentPane(painel);
        setTitle("Formulario medicamento");
        setSize(500, 200);
        setVisible(true);
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                efermidade.setNome(textNomeEfermidade.getText());
                efermidadeDao.insert(efermidade);
            }
        });
    }

    public static void main(String[] args) {
        EfermidadeGui efermidadeGui = new EfermidadeGui();
    }

}
