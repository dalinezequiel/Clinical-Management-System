/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
/**
 *
 * @author Dalin Ezequiel
 */
public class MedicoView extends JDialog
{
    private JLabel lbCodigo, lbNome, lbApelido,lbGenero,lbNascimento,lbDocumento,lbNrDocumento,
            lbEspecialidade,lbSalario,lbConsultorio,lbTelefone,lbEmail,lbProvincia,lbCidade,lbBairro,lbRua;
    private JTextField txtCodigo,txtNome, txtApelido,txtNascimento,txtDocumento, txtNrDocumento,
            txtSalario,txtTelefone,txtEmail,txtProvincia,txtCidade, txtBairro,txtRua;
    private JComboBox<String> boxGenero, boxDocumento, boxEspecialidade,boxConsultorio,boxProvincia,boxCidade;
    private JCheckBox rdEstado;
    private JButton btnCadastrar,btnActualizar,btnCancelar;
    private ImageIcon cadastrar,actualizar,cancelar;
    private int tamanhoFonteCaixaTexto;
    private DecimalFormat moeda;

    private void componente()
    {
        tamanhoFonteCaixaTexto = 14;
        moeda = new DecimalFormat("###.00");
        cancelar = new ImageIcon("image/exit.png");
        cadastrar = new ImageIcon("image/entrar.png");
        actualizar = new ImageIcon("image/actualizar.png");
        
        lbCodigo =  new JLabel("CÓDIGO");
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
        lbCidade = new JLabel("CIDADE");
        lbBairro = new JLabel("BAIRRO");
        lbRua = new JLabel("RUA");
        
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
        
        boxGenero = new JComboBox<String>();
        boxDocumento = new JComboBox<String>();
        boxEspecialidade = new JComboBox<String>();
        boxConsultorio = new JComboBox<String>();
        boxProvincia = new JComboBox<String>();
        boxCidade = new JComboBox<String>();
        
        rdEstado = new JCheckBox("Médico Activo?");
        
        btnCadastrar = new JButton("CADASTRAR");
        btnActualizar = new JButton("ACTUALIZAR");
        btnCancelar = new JButton("CANCELAR");
        
        lbCodigo.setBounds(50,25,100,30);
        add(lbCodigo);
        txtCodigo.setBounds(50,50,100,30);
        txtCodigo.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtCodigo);
        
        lbNome.setBounds(170,25,100,30);
        add(lbNome);
        txtNome.setBounds(170,50,180,30);
        txtNome.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtNome);
        
        lbApelido.setBounds(370,25,100,30);
        add(lbApelido);
        txtApelido.setBounds(370,50,250,30);
        txtApelido.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtApelido);
        
        lbGenero.setBounds(50,80,100,30);
        add(lbGenero);
        boxGenero.setBounds(50,105,180,30);
        add(boxGenero);
        
        lbNascimento.setBounds(250,80,150,30);
        add(lbNascimento);
        txtNascimento.setBounds(250,105,160,30);
        add(txtNascimento);
        
        lbDocumento.setBounds(430,80,100,30);
        add(lbDocumento);
        boxDocumento.setBounds(430,105,190,30);
        add(boxDocumento);
        
        lbNrDocumento.setBounds(50,135,100,30);
        add(lbNrDocumento);
        txtNrDocumento.setBounds(50,160,180,30);
        add(txtNrDocumento);
        
        lbEspecialidade.setBounds(50,195,150,30);
        add(lbEspecialidade);
        boxEspecialidade.setBounds(50,220,260,30);
        add(boxEspecialidade);
        
        lbSalario.setBounds(330,195,100,30);
        add(lbSalario);
        txtSalario.setBounds(330,220,150,30);
        txtSalario.setText(moeda.format(Double.parseDouble("0")));
        add(txtSalario);
        
        lbConsultorio.setBounds(500,195,100,30);
        add(lbConsultorio);
        boxConsultorio.setBounds(500,220,120,30);
        add(boxConsultorio);
        
        lbTelefone.setBounds(50,255,100,30);
        add(lbTelefone);
        txtTelefone.setBounds(50,280,160,30);
        add(txtTelefone);
        
        lbEmail.setBounds(230,255,100,30);
        add(lbEmail);
        txtEmail.setBounds(230,280,250,30);
        add(txtEmail);
        
        lbProvincia.setBounds(50,315,100,30);
        add(lbProvincia);
        boxProvincia.setBounds(50,340,200,30);
        add(boxProvincia);
        
        lbCidade.setBounds(270,315,100,30);
        add(lbCidade);
        boxCidade.setBounds(270,340,200,30);
        add(boxCidade);
        
        lbBairro.setBounds(490,315,100,30);
        add(lbBairro);
        txtBairro.setBounds(490,340,130,30);
        add(txtBairro);
        
        lbRua.setBounds(50,370,100,30);
        add(lbRua);
        txtRua.setBounds(50,395,200,30);
        add(txtRua);
        
        rdEstado.setBounds(270,395,170,30);
        add(rdEstado);
        
        btnCadastrar.setBounds(50,450,180,50);
        btnCadastrar.setFont(new Font("Montserrat",Font.BOLD,14));
        btnCadastrar.setIcon(cadastrar);
        add(btnCadastrar);
        
        btnActualizar.setBounds(240,450,180,50);
        btnActualizar.setFont(new Font("Montserrat",Font.BOLD,14));
        btnActualizar.setIcon(actualizar);
        add(btnActualizar);
        
        btnCancelar.setBounds(440,450,180,50);
        btnCancelar.setFont(new Font("Montserrat",Font.BOLD,14));
        btnCancelar.setIcon(cancelar);
        btnCancelar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               dispose();
           }
        });
        add(btnCancelar);
        
    }
    private void tela()
    {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("FICHA DO MÉDICO");
        setSize(690,595);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public MedicoView()
    {
        componente();
        tela();
    }
}
