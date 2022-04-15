/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.PacienteSQL;
import Model.PacienteModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalin Ezequiel
 */
public class ConsultaPacienteView extends JDialog {

    private JTable tabela;
    private JScrollPane scrol;
    private JButton btnNovo, btnRemover, btnCancelar, btnPesquisa, btnRelatorio, btnProntoario, btnSelec;
    private JLabel lbCodigo, lbNome, lbEspecialidade;
    private JTextField txtCodigo, txtNome;
    private JComboBox<String> boxEspecialidade;
    private ImageIcon novo, remover, cancelar, pesquisa, relatorio, especialidade, selec;

    private PacienteModel pm;
    private DefaultTableModel tb;
    private PacienteSQL os;

    private void componente() {
        pm = new PacienteModel();

        novo = new ImageIcon("image/novo.png");
        cancelar = new ImageIcon("image/exit.png");
        remover = new ImageIcon("image/remover.png");
        pesquisa = new ImageIcon("image/pesquisar.png");
        relatorio = new ImageIcon("image/rel.png");
        especialidade = new ImageIcon("image/especialidade.png");
        selec = new ImageIcon("image/selec.png");

        btnNovo = new JButton("NOVO");
        btnRemover = new JButton("REMOVER");
        btnCancelar = new JButton("CANCELAR");
        btnPesquisa = new JButton("PESQUISAR");
        btnRelatorio = new JButton("RELATÓRIO");
        btnProntoario = new JButton("PRONTOÁRIO");
        btnSelec = new JButton("SEL");

        lbCodigo = new JLabel("CÓDIGO");
        lbNome = new JLabel("NOME");
        lbEspecialidade = new JLabel("ESPECIALIDADE");

        txtCodigo = new JTextField();
        txtNome = new JTextField();

        boxEspecialidade = new JComboBox<String>();

        lbCodigo.setBounds(50, 50, 100, 30);
        add(lbCodigo);
        txtCodigo.setBounds(50, 75, 100, 30);
        txtCodigo.setFont(new Font("Montserrat", Font.BOLD, 14));
        txtCodigo.setFocusable(true);
        txtCodigo.setEditable(false);
        add(txtCodigo);

        lbNome.setBounds(160, 50, 100, 30);
        add(lbNome);
        txtNome.setBounds(160, 75, 220, 30);
        txtNome.setFont(new Font("Montserrat", Font.BOLD, 14));
        txtNome.setEditable(false);
        add(txtNome);

        lbEspecialidade.setBounds(390, 50, 100, 30);
        add(lbEspecialidade);
        boxEspecialidade.setBounds(390, 75, 280, 30);
        boxEspecialidade.setFont(new Font("Montserrat", Font.PLAIN, 14));
        boxEspecialidade.addItem("Codigo Paciente");
        boxEspecialidade.addItem("Nome Paciente");
        boxEspecialidade.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (boxEspecialidade.getSelectedItem().equals("Codigo Paciente")) {
                    txtCodigo.setEditable(true);
                    txtNome.setEditable(false);
                    txtNome.setText("");
                } else {
                    txtNome.setEditable(true);
                    txtCodigo.setEditable(false);
                    txtCodigo.setText("");
                }
            }
        });
        add(txtNome);
        add(boxEspecialidade);

        tabela = new JTable();
        tabela.setRowHeight(30);
        tabela.setFont(new Font("Montserrat", Font.PLAIN, 14));
        scrol = new JScrollPane(tabela);
        scrol.setBounds(50, 130, 950, 400);
        add(scrol);

        tb = (DefaultTableModel) tabela.getModel();
        tb.setRowCount(0);

        tb.addColumn("CODIGO");
        tb.addColumn("NOME");
        tb.addColumn("APELIDO");
        tb.addColumn("GENERO");
        tb.addColumn("IDENTIFICACAO");
        tb.addColumn("NR IDENTIFICAO");
        /*tb.addColumn("NOME PAI");
        tb.addColumn("NOME MAE");
        tb.addColumn("NOME PAI");
        tb.addColumn("TELEFONE");
        tb.addColumn("EMAIL");
        tb.addColumn("PROVINCIA");
        tb.addColumn("CIDADE");
        tb.addColumn("BAIRRO");
        tb.addColumn("RUA");
        tb.addColumn("ESTADO");
        tb.addColumn("DATA REGISTO");*/

        PacienteSQL.populaPaciente(tb);

        btnPesquisa.setBounds(825, 65, 170, 50);
        btnPesquisa.setFocusable(false);
        btnPesquisa.setIcon(pesquisa);
        btnPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!txtCodigo.getText().isEmpty()) {
                    PacienteSQL.populapesquisaPacienteAll(tb, Integer.parseInt(txtCodigo.getText()), "");
                } else {
                    if (!txtNome.getText().isEmpty()) {
                        PacienteSQL.populapesquisaPacienteAll(tb, 0, txtCodigo.getText());
                    } else {
                        PacienteSQL.populaPaciente(tb);
                    }
                }
            }
        });
        add(btnPesquisa);

        btnNovo.setBounds(50, 550, 150, 55);
        btnNovo.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnNovo.setIcon(novo);
        btnNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PacienteView(0, "", "", "", "", "", false);
                PacienteSQL.populaPaciente(tb);
            }
        });
        add(btnNovo);

        btnRemover.setBounds(210, 550, 150, 55);
        btnRemover.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnRemover.setIcon(remover);
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int select = tabela.getSelectedRow();
                if (select != -1) {
                    int respost = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o paciente \n[" + tabela.getModel().getValueAt(select, 1).toString().toUpperCase()
                            + "]", "exclusao", JOptionPane.YES_NO_OPTION);

                    if (respost == 0) {
                        PacienteSQL.deleteById(Integer.parseInt(tabela.getModel().getValueAt(select, 0).toString()));
                        PacienteSQL.populaPaciente(tb);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Paciente não selecionado. Verifique!", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnRemover);

        btnRelatorio.setBounds(370, 550, 150, 55);
        btnRelatorio.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnRelatorio.setIcon(relatorio);
        add(btnRelatorio);

        btnProntoario.setBounds(530, 550, 180, 55);
        btnProntoario.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnProntoario.setIcon(especialidade);
        btnProntoario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(btnProntoario);

        btnSelec.setBounds(720, 550, 120, 55);
        btnSelec.setIcon(selec);
        btnSelec.setFont(new Font("Montserrat", Font.BOLD, 14));
        add(btnSelec);
        btnSelec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int select = tabela.getSelectedRow();
                if (select != -1) {
                    pm.setIDPaciente(Integer.parseInt(tabela.getModel().getValueAt(select, 0).toString()));
                    pm.setNome(tabela.getModel().getValueAt(select, 1).toString());
                    pm.setApelido(tabela.getModel().getValueAt(select, 2).toString());
                    pm.setGenero(tabela.getModel().getValueAt(select, 3).toString());
                    pm.setIdentificao(tabela.getModel().getValueAt(select, 4).toString());
                    pm.setNrDocumento(tabela.getModel().getValueAt(select, 5).toString());
                    new PacienteView(pm.getIDPaciente(), pm.getNome(), pm.getApelido(), pm.getGenero(), pm.getIdentificao(), pm.getNrDocumento(), true);
                    PacienteSQL.populaPaciente(tb);

                } else {
                    JOptionPane.showMessageDialog(null, "Paciente não selecionado. Verifique!", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.setBounds(850, 550, 150, 55);
        btnCancelar.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnCancelar.setIcon(cancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCancelar);
    }

    private void tela() {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("LISTA DE PACIENTES");
        setSize(1070, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public ConsultaPacienteView() {
        componente();
        tela();
    }
}
