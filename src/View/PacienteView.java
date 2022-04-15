/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import Model.DAO.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalin Ezequiel
 */
public class PacienteView extends JDialog {

    private PreparedStatement pst = null;
    private Connection con = null;
    private PacienteSQL op;
    private JLabel lbCodigo, lbNome, lbApelido, lbGenero, lbNascimento, lbDocumento, lbNrDocumento,
            lbEspecialidade, lbSalario, lbConsultorio, lbTelefone, lbEmail, lbProvincia, lbDistrito, lbBairro, lbRua,
            lbPai, lbMae;
    private JTextField txtCodigo, txtNome, txtApelido, txtNascimento, txtDocumento, txtNrDocumento,
            txtSalario, txtTelefone, txtEmail, txtProvincia, txtCidade, txtBairro, txtRua, txtPai, txtMae;
    private JComboBox<String> boxGenero, boxDocumento, boxEspecialidade, boxConsultorio, boxProvincia, boxDistrito;
    private JCheckBox rdEstado;
    private JButton btnCadastrar, btnActualizar, btnCancelar;
    private ImageIcon cadastrar, actualizar, cancelar;
    private int tamanhoFonteCaixaTexto;
    private DecimalFormat moeda;
    private Date data = new Date();
    private SimpleDateFormat sdf;

    private boolean bloqueio;
    private PacienteModel pm;
    private DefaultTableModel tb;
    private PacienteSQL os;
    private PacienteModel pac = new PacienteModel();
    private ArrayList<GeneroModel> listGenero = null;
    private ArrayList<ProvinciaModel> listProvincia = null;
    private ArrayList<DocumentoModel> listDocumento = null;
    private ArrayList<DistritoModel> listDistrito = null;

    private void componente() {

        tamanhoFonteCaixaTexto = 14;
        moeda = new DecimalFormat("###.00");
        cancelar = new ImageIcon("image/exit.png");
        cadastrar = new ImageIcon("image/entrar.png");
        actualizar = new ImageIcon("image/actualizar.png");

        lbCodigo = new JLabel("CÓDIGO");
        lbNome = new JLabel("NOME");
        lbApelido = new JLabel("APELIDO");
        lbGenero = new JLabel("GÊNERO");
        lbNascimento = new JLabel("DATA NASCIMENTO");
        lbDocumento = new JLabel("IDENTIFICAÇÃO");
        lbNrDocumento = new JLabel("NR DOCUMENTO");
        lbEspecialidade = new JLabel("ESPECIALIDADE MÉDICA");
        lbSalario = new JLabel("SALÁRIO");
        lbConsultorio = new JLabel("CONSULTÓRIO");
        lbTelefone = new JLabel("TELEFONE");
        lbEmail = new JLabel("EMAIL");
        lbProvincia = new JLabel("PROVÍNCIA");
        lbDistrito = new JLabel("DISTRITO");
        lbBairro = new JLabel("BAIRRO");
        lbRua = new JLabel("RUA");
        lbPai = new JLabel("NOME DO PAI");
        lbMae = new JLabel("NOME DA MÃE");

        txtCodigo = new JTextField();
        txtNome = new JTextField();
        txtApelido = new JTextField();
        txtNascimento = new JTextField();
        txtDocumento = new JTextField();
        txtNrDocumento = new JTextField();
        txtSalario = new JTextField();
        txtTelefone = new JTextField();
        txtEmail = new JTextField();
        txtBairro = new JTextField();
        txtRua = new JTextField();
        txtPai = new JTextField();
        txtMae = new JTextField();

        boxGenero = new JComboBox<String>();
        boxDocumento = new JComboBox<String>();
        boxEspecialidade = new JComboBox<String>();
        boxConsultorio = new JComboBox<String>();
        boxProvincia = new JComboBox<String>();
        boxDistrito = new JComboBox<String>();

        rdEstado = new JCheckBox("Paciente Activo?");

        btnCadastrar = new JButton("CADASTRAR");
        btnActualizar = new JButton("ACTUALIZAR");
        btnCancelar = new JButton("CANCELAR");

        lbCodigo.setBounds(50, 25, 100, 30);
        add(lbCodigo);
        txtCodigo.setBounds(50, 50, 100, 30);
        txtCodigo.setFont(new Font("Montserrat", Font.BOLD, tamanhoFonteCaixaTexto));
        if (pac.getIDPaciente() == 0) {
            txtCodigo.setText("");
        } else {
            txtCodigo.setText(String.valueOf(pac.getIDPaciente()));
        }
        add(txtCodigo);

        lbNome.setBounds(170, 25, 100, 30);
        add(lbNome);
        txtNome.setBounds(170, 50, 180, 30);
        txtNome.setFont(new Font("Montserrat", Font.BOLD, tamanhoFonteCaixaTexto));
        txtNome.setText(pac.getNome());
        add(txtNome);

        lbApelido.setBounds(370, 25, 100, 30);
        add(lbApelido);
        txtApelido.setBounds(370, 50, 250, 30);
        txtApelido.setFont(new Font("Montserrat", Font.BOLD, tamanhoFonteCaixaTexto));
        txtApelido.setText(pac.getApelido());
        add(txtApelido);

        lbGenero.setBounds(50, 80, 100, 30);
        add(lbGenero);
        boxGenero.setBounds(50, 105, 180, 30);
        boxGenero.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(boxGenero);

        lbNascimento.setBounds(250, 80, 150, 30);
        add(lbNascimento);
        txtNascimento.setBounds(250, 105, 160, 30);
        txtNascimento.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtNascimento);

        lbDocumento.setBounds(430, 80, 100, 30);
        add(lbDocumento);
        boxDocumento.setBounds(430, 105, 190, 30);
        boxDocumento.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(boxDocumento);

        lbNrDocumento.setBounds(50, 135, 100, 30);
        add(lbNrDocumento);
        txtNrDocumento.setBounds(50, 160, 180, 30);
        txtNrDocumento.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        txtNrDocumento.setText(pac.getNrDocumento());
        add(txtNrDocumento);

        lbPai.setBounds(50, 195, 150, 30);
        add(lbPai);
        txtPai.setBounds(50, 220, 260, 30);
        txtPai.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtPai);

        lbMae.setBounds(320, 195, 150, 30);
        add(lbMae);
        txtMae.setBounds(320, 220, 260, 30);
        txtMae.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtMae);

        lbTelefone.setBounds(50, 255, 100, 30);
        add(lbTelefone);
        txtTelefone.setBounds(50, 280, 160, 30);
        txtTelefone.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtTelefone);

        lbEmail.setBounds(230, 255, 100, 30);
        add(lbEmail);
        txtEmail.setBounds(230, 280, 250, 30);
        txtEmail.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtEmail);

        lbProvincia.setBounds(50, 315, 100, 30);
        add(lbProvincia);
        boxProvincia.setBounds(50, 340, 200, 30);
        boxProvincia.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        boxProvincia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (boxProvincia.getSelectedItem().equals("Maputo")) {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(1);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Gaza"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(2);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Inhambane"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(3);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Sofala"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(4);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Manica"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(5);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Tete"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(6);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Zambezia"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(7);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Nampula"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(8);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else if(boxProvincia.getSelectedItem().equals("Cabo Delgado"))
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(9);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }else
                {
                    boxDistrito.removeAllItems();
                    listDistrito = DistritoSQL.retornaDistrito(10);
                    for(int i=0; i<listDistrito.size(); i++)
                    {
                        boxDistrito.addItem(listDistrito.get(i).getDistrito());
                    }
                }
            }
        });
        add(boxProvincia);

        lbDistrito.setBounds(270, 315, 100, 30);
        add(lbDistrito);
        boxDistrito.setBounds(270, 340, 200, 30);
        boxDistrito.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(boxDistrito);

        lbBairro.setBounds(490, 315, 100, 30);
        add(lbBairro);
        txtBairro.setBounds(490, 340, 130, 30);
        txtBairro.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtBairro);

        lbRua.setBounds(50, 370, 100, 30);
        add(lbRua);
        txtRua.setBounds(50, 395, 200, 30);
        txtRua.setFont(new Font("Montserrat", Font.PLAIN, tamanhoFonteCaixaTexto));
        add(txtRua);

        rdEstado.setBounds(270, 395, 170, 30);
        add(rdEstado);
        data = new Date();
        btnCadastrar.setBounds(50, 450, 180, 50);
        btnCadastrar.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnCadastrar.setIcon(cadastrar);
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                long dt = data.getTime();
                java.sql.Date df = new java.sql.Date(dt);

                pac.setIDPaciente(Integer.parseInt(txtCodigo.getText()));
                pac.setNome(txtNome.getText());
                pac.setApelido(txtApelido.getText());
                pac.setGenero(boxGenero.getSelectedItem().toString());
                pac.setIdentificao(boxDocumento.getSelectedItem().toString());
                pac.setNrDocumento(txtNrDocumento.getText());

                new PacienteSQL().cadastroAll(con, pst, pac);

                txtCodigo.setText("");
                txtNome.setText("");
            }
        });
        add(btnCadastrar);

        btnActualizar.setBounds(240, 450, 180, 50);
        btnActualizar.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnActualizar.setIcon(actualizar);
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                op = new PacienteSQL();
                pac.setIDPaciente(Integer.parseInt(txtCodigo.getText()));
                pac.setNome(txtNome.getText());
                pac.setApelido(txtApelido.getText());
                pac.setGenero(boxGenero.getSelectedItem().toString());
                pac.setIdentificao(boxDocumento.getSelectedItem().toString());
                pac.setNrDocumento(txtNrDocumento.getText());
                PacienteSQL.actualizaById(pac);
            }
        });
        add(btnActualizar);

        btnCancelar.setBounds(440, 450, 180, 50);
        btnCancelar.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnCancelar.setIcon(cancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btnCancelar);

        if (bloqueio) {
            txtCodigo.setEditable(false);
            btnCadastrar.setEnabled(false);
            rdEstado.setVisible(false);
            //boxGenero.removeAllItems();
            listGenero = GeneroSQL.retornaGenero();
            for (int i = 0; i < listGenero.size(); i++) {
                boxGenero.addItem(listGenero.get(i).getGenero());
            }

            listProvincia = ProvinciaSQL.retornaProvincia();
            for (int i = 0; i < listProvincia.size(); i++) {
                boxProvincia.addItem(listProvincia.get(i).getProvincia());
            }

            listDocumento = DocumentoSQL.retornaDocumento();
            for (int i = 0; i < listDocumento.size(); i++) {
                boxDocumento.addItem(listDocumento.get(i).getDocumento());
            }

            boxDocumento.setSelectedItem(pac.getIdentificao());
            boxGenero.setSelectedItem(pac.getGenero());

        } else {
            btnActualizar.setEnabled(false);
            listGenero = GeneroSQL.retornaGenero();
            for (int i = 0; i < listGenero.size(); i++) {
                boxGenero.addItem(listGenero.get(i).getGenero());
            }

            listProvincia = ProvinciaSQL.retornaProvincia();
            for (int i = 0; i < listProvincia.size(); i++) {
                boxProvincia.addItem(listProvincia.get(i).getProvincia());
            }

            listDocumento = DocumentoSQL.retornaDocumento();
            for (int i = 0; i < listDocumento.size(); i++) {
                boxDocumento.addItem(listDocumento.get(i).getDocumento());
            }
        }
    }

    private void tela() {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("FICHA DO PACIENTE");
        setSize(690, 595);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public PacienteView(int codigo, String nome, String apelido, String genero, String documento, String nrDocumento, boolean b) {
        pac.setIDPaciente(codigo);
        pac.setNome(nome);
        pac.setApelido(apelido);
        pac.setGenero(genero);
        pac.setIdentificao(documento);
        pac.setNrDocumento(nrDocumento);
        bloqueio = b;

        componente();
        tela();
    }

    public PacienteView() {
        componente();
        tela();
    }
}
