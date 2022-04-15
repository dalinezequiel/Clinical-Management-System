/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Report.ReportServicoClinico;
import Model.DAO.ServicoClinicoSQL;
import Model.ServicoClinicoModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalin Ezequiel
 */
public class ConsultaServicoClinicoView extends JDialog {

    private JTable tabela;
    private JScrollPane scrol;
    private JButton btnNovo, btnRemover, btnCancelar, btnPesquisa, btnSelect, btnRelatorio;
    private JLabel lbCodigo, lbServicoClinico, lbData;
    private JTextField txtCodigo, txtServicoClinico, txtData;
    private ImageIcon novo, remover, cancelar, pesquisa, selec, relatorio;

    private ArrayList<ServicoClinicoModel> sc = null;
    private ServicoClinicoModel scm = null;
    private DefaultTableModel tb;

    private void componente() {
        novo = new ImageIcon("image/novo.png");
        cancelar = new ImageIcon("image/exit.png");
        remover = new ImageIcon("image/remover.png");
        pesquisa = new ImageIcon("image/pesquisar.png");
        relatorio = new ImageIcon("image/rel.png");
        selec = new ImageIcon("image/selec.png");

        btnNovo = new JButton("NOVO");
        btnRemover = new JButton("REMOVER");
        btnCancelar = new JButton("CANCELAR");
        btnPesquisa = new JButton("PESQUISAR");
        btnRelatorio = new JButton("RELATÓRIO");
        btnSelect = new JButton("SEL");

        lbCodigo = new JLabel("CÓDIGO");
        lbServicoClinico = new JLabel("SERVIÇO CLÍNICO");
        lbData = new JLabel("DATA");

        txtCodigo = new JTextField();
        txtServicoClinico = new JTextField();
        txtData = new JTextField();

        lbCodigo.setBounds(30, 10, 100, 30);
        add(lbCodigo);
        txtCodigo.setBounds(30, 35, 100, 30);
        txtCodigo.setFocusable(true);
        add(txtCodigo);

        lbServicoClinico.setBounds(140, 10, 200, 30);
        add(lbServicoClinico);
        txtServicoClinico.setBounds(140, 35, 270, 30);
        add(txtServicoClinico);

        lbData.setBounds(420, 10, 100, 30);
        add(lbData);
        txtData.setBounds(420, 35, 150, 30);
        add(txtData);

        tabela = new JTable();
        scrol = new JScrollPane(tabela);
        scrol.setBounds(30, 100, 720, 300);
        tabela.setRowHeight(30);
        tabela.setFont(new Font("Montserrat", Font.PLAIN, 14));
        add(scrol);

        tb = (DefaultTableModel) tabela.getModel();
        tb.setRowCount(0);

        tb.addColumn("CODIGO");
        tb.addColumn("SERVICO CLINICO");
        tb.addColumn("VALOR");
        tb.addColumn("ESTADO");
        tb.addColumn("DATA REGISTO");

        ServicoClinicoSQL.populaServicoClinico(tb);

        btnPesquisa.setBounds(600, 33, 150, 45);
        btnPesquisa.setFocusable(false);
        btnPesquisa.setIcon(pesquisa);
        btnPesquisa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (txtCodigo.getText().isEmpty() && txtServicoClinico.getText().isEmpty() && txtData.getText().isEmpty()) {
                    ServicoClinicoSQL.populaServicoClinico(tb);
                } else {
                    if (txtCodigo.getText().isEmpty() && txtData.getText().isEmpty()) {
                        ServicoClinicoSQL.populaPesquisaAll(tb, Integer.parseInt("0"), txtServicoClinico.getText(), "1000-01-01");
                    } else {
                        if (txtCodigo.getText().isEmpty()) {
                            ServicoClinicoSQL.populaPesquisaAll(tb, Integer.parseInt("0"), txtServicoClinico.getText(), txtData.getText());
                        } else if (txtData.getText().isEmpty()) {
                            ServicoClinicoSQL.populaPesquisaAll(tb, Integer.parseInt(txtCodigo.getText()), txtServicoClinico.getText(), "1000-01-01");
                        } else {
                            ServicoClinicoSQL.populaPesquisaAll(tb, Integer.parseInt(txtCodigo.getText()), txtServicoClinico.getText(), txtData.getText());
                        }
                    }
                }
            }
        });
        add(btnPesquisa);

        btnNovo.setBounds(30, 420, 130, 50);
        btnNovo.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnNovo.setIcon(novo);
        btnNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ServicoClinicoView(0, "", 0, "", null, false);
                ServicoClinicoSQL.populaServicoClinico(tb);
            }
        });
        add(btnNovo);

        btnRemover.setBounds(170, 420, 150, 50);
        btnRemover.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnRemover.setIcon(remover);
        btnRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int select = tabela.getSelectedRow();
                if (select != -1) {
                    int respost = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o serviço clínico? \n[" + tabela.getModel().getValueAt(select, 1).toString().toUpperCase()
                            + "]", "exclusao", JOptionPane.YES_NO_OPTION);
                    if (respost == 0) {
                        ServicoClinicoSQL.deleteById(Integer.parseInt(tabela.getModel().getValueAt(select, 0).toString()));
                        ServicoClinicoSQL.populaServicoClinico(tb);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Serviço clínico não selecionado. Verifique!", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnRemover);

        btnRelatorio.setBounds(330, 420, 150, 50);
        btnRelatorio.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnRelatorio.setIcon(relatorio);
        btnRelatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtCodigo.getText().isEmpty() && txtData.getText().isEmpty()) {
                    new ReportServicoClinico(Integer.parseInt("0"), txtServicoClinico.getText(), "1000-01-01");
                } else {
                    if (txtCodigo.getText().isEmpty()) {
                        new ReportServicoClinico(Integer.parseInt("0"), txtServicoClinico.getText(), txtData.getText());
                    } else {
                        if (txtData.getText().isEmpty()) {
                            new ReportServicoClinico(Integer.parseInt(txtCodigo.getText()), txtServicoClinico.getText(), "1000-01-01");
                        } else {
                            new ReportServicoClinico(Integer.parseInt(txtCodigo.getText()), txtServicoClinico.getText(), txtData.getText());
                        }
                    }
                }
            }
        });
        add(btnRelatorio);

        btnSelect.setBounds(490, 420, 100, 50);
        btnSelect.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnSelect.setIcon(selec);
        btnSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scm = new ServicoClinicoModel();
                int select = tabela.getSelectedRow();
                if (select != -1) {
                    scm.setCodigo(Integer.parseInt(tabela.getModel().getValueAt(select, 0).toString()));
                    scm.setServicoClinico(tabela.getModel().getValueAt(select, 1).toString());
                    scm.setValor(Double.parseDouble(tabela.getValueAt(select, 2).toString()));
                    scm.setEstado(tabela.getModel().getValueAt(select, 3).toString());
                    scm.setDataRegisto(Date.valueOf(tabela.getModel().getValueAt(select, 4).toString()));
                    new ServicoClinicoView(scm.getCodigo(), scm.getServicoClinico(), scm.getValor(), scm.getEstado(), scm.getDataRegisto(), true);
                    ServicoClinicoSQL.populaServicoClinico(tb);
                } else {
                    JOptionPane.showMessageDialog(null, "Serviço clínico não selecionado. Verifique!", "erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(btnSelect);

        btnCancelar.setBounds(600, 420, 150, 50);
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
        setTitle("CONSULTA SERVIÇO CLÍNICO");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public ConsultaServicoClinicoView() {
        componente();
        tela();
    }
}
