/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.ServicoClinicoSQL;
import Model.ServicoClinicoModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.*;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Dalin Ezequiel
 */
public class ServicoClinicoView extends JDialog {

    private JLabel lbCodigo, lbServicoClinico, lbValor;
    private JTextField txtCodigo, txtServicoClinico, txtValor;
    private JCheckBox chkEstado;
    private JButton btnCadastrar, btnActualizar, btnCancelar;
    private ImageIcon cadastrar, actualizar, cancelar;
    private int tamanhoFonteCaixaTexto;
    private DecimalFormat moeda;
    private ServicoClinicoModel sc = new ServicoClinicoModel();
    private boolean actualiza;

    private void componente() 
    {
        tamanhoFonteCaixaTexto = 14;
        moeda = new DecimalFormat("###.00");
        cancelar = new ImageIcon("image/exit.png");
        cadastrar = new ImageIcon("image/entrar.png");
        actualizar = new ImageIcon("image/actualizar.png");

        lbCodigo = new JLabel("CÓDIGO");
        lbServicoClinico = new JLabel("SERVIÇO CLÍNICO");
        lbValor = new JLabel("VALOR");

        txtCodigo = new JTextField();
        txtServicoClinico = new JTextField();
        txtValor = new JTextField();

        chkEstado = new JCheckBox("Serviço clínico activo?");

        btnCadastrar = new JButton("CADASTRAR");
        btnActualizar = new JButton("ACTUALIZAR");
        btnCancelar = new JButton("CANCELAR");

        lbCodigo.setBounds(30, 25, 100, 30);
        add(lbCodigo);
        txtCodigo.setBounds(30, 50, 100, 30);
        txtCodigo.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        txtCodigo.setText(String.valueOf(sc.getCodigo()));
        if(sc.getCodigo() == 0)
        {
            txtCodigo.setText("");
        }else
        {
            txtCodigo.setText(String.valueOf(sc.getCodigo()));
        }
        add(txtCodigo);

        lbServicoClinico.setBounds(140, 25, 200, 30);
        add(lbServicoClinico);
        txtServicoClinico.setBounds(140, 50, 290, 30);
        txtServicoClinico.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        txtServicoClinico.setText(sc.getServicoClinico());
        add(txtServicoClinico);

        lbValor.setBounds(30, 80, 100, 30);
        add(lbValor);
        txtValor.setBounds(30, 105, 180, 40);
        txtValor.setFont(new Font("Montserrat", Font.BOLD, 16));
        if(sc.getValor() == 0)
        {
            txtValor.setText("0.00");
        }else
        {
            txtValor.setText(String.valueOf(moeda.format(sc.getValor())));
        }
        add(txtValor);

        chkEstado.setBounds(230, 105, 170, 30);
        if(sc.getEstado().equals("Activo"))
        {
            chkEstado.setSelected(true);
        }else
        {
            chkEstado.setSelected(false);
        }
        add(chkEstado);

        btnCadastrar.setBounds(30, 260, 145, 50);
        btnCadastrar.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnCadastrar.setIcon(cadastrar);
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date dat = Date.valueOf(java.time.LocalDate.now());
                sc = new ServicoClinicoModel();
                if (chkEstado.isSelected()) {
                    sc.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    sc.setServicoClinico(txtServicoClinico.getText());
                    sc.setValor(Double.parseDouble(txtValor.getText()));
                    sc.setEstado("Activo");
                    sc.setDataRegisto(dat);
                    ServicoClinicoSQL.cadastroAll(sc);
                    txtCodigo.setText(""); txtServicoClinico.setText(""); txtValor.setText(""); chkEstado.setSelected(false);
                } else {

                    sc.setCodigo(Integer.parseInt(txtCodigo.getText()));
                    sc.setServicoClinico(txtServicoClinico.getText());
                    sc.setValor(Double.parseDouble(txtValor.getText()));
                    sc.setEstado("Inactivo");
                    sc.setDataRegisto(dat);
                    ServicoClinicoSQL.cadastroAll(sc);
                    txtCodigo.setText(""); txtServicoClinico.setText(""); txtValor.setText(""); chkEstado.setSelected(false);
                }
            }
        });
        add(btnCadastrar);

        btnActualizar.setBounds(185, 260, 145, 50);
        btnActualizar.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnActualizar.setIcon(actualizar);
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                sc.setCodigo(Integer.parseInt(txtCodigo.getText()));
                sc.setServicoClinico(txtServicoClinico.getText());
                sc.setValor(Double.parseDouble(txtValor.getText()));
                if(chkEstado.isSelected())
                {
                    sc.setEstado("Activo");
                }else
                {
                    sc.setEstado("Inactivo");
                }
                sc.setDataRegisto(sc.getDataRegisto());
                
                ServicoClinicoSQL.actualizaAll(sc);
            }
        });
        add(btnActualizar);

        btnCancelar.setBounds(340, 260, 145, 50);
        btnCancelar.setFont(new Font("Montserrat", Font.BOLD, 12));
        btnCancelar.setIcon(cancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCancelar);
        
        if(actualiza)
        {
            btnActualizar.setEnabled(true);
            btnCadastrar.setEnabled(false);
            txtCodigo.setEditable(false);
        }else
        {
            btnCadastrar.setEnabled(true);
            btnActualizar.setEnabled(false);
        }
    }

    private void tela() {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("SERVIÇO CLÍNICO");
        setSize(535, 390);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    public ServicoClinicoView(int codigo, String serv, double valor, String estado, Date dataRegisto, boolean act)
    {
        sc.setCodigo(codigo);
        sc.setServicoClinico(serv);
        sc.setValor(valor);
        sc.setEstado(estado);
        sc.setDataRegisto(dataRegisto);
        actualiza = act;
        componente();
        tela();
    }
    public ServicoClinicoView() 
    {
        componente();
        tela();
    }
}
