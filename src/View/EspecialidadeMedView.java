/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
/**
 *
 * @author Dalin Ezequiel
 */
public class EspecialidadeMedView extends JDialog
{
    
    private JLabel lbCodigo, lbEspecialidade, lbSalario;
    private JTextField txtCodigo,txtEspecialidade, txtSalario;
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
        lbEspecialidade = new JLabel("ESPECIALIDADE MÉDICA");
        lbSalario = new JLabel("SALÁRIO");
        
        txtCodigo = new JTextField();
        txtEspecialidade = new JTextField();
        txtSalario = new JTextField();
        
        rdEstado = new JCheckBox("Especialidade Activa?");
        
        btnCadastrar = new JButton("CADASTRAR");
        btnActualizar = new JButton("ACTUALIZAR");
        btnCancelar = new JButton("CANCELAR");
        
        lbCodigo.setBounds(30,25,100,30);
        add(lbCodigo);
        txtCodigo.setBounds(30,50,100,30);
        txtCodigo.setFont(new Font("Montserrat",Font.PLAIN,tamanhoFonteCaixaTexto));
        add(txtCodigo);
        
        lbEspecialidade.setBounds(140,25,200,30);
        add(lbEspecialidade);
        txtEspecialidade.setBounds(140,50,290,30);
        txtEspecialidade.setFont(new Font("Montserrat",Font.PLAIN,tamanhoFonteCaixaTexto));
        add(txtEspecialidade);
        
        lbSalario.setBounds(30,80,100,30);
        add(lbSalario);
        txtSalario.setBounds(30,105,180,40);
        txtSalario.setText(moeda.format(Double.parseDouble("0")));
        txtSalario.setFont(new Font("Montserrat",Font.BOLD,16));
        add(txtSalario);
        
        rdEstado.setBounds(230,105,170,30);
        add(rdEstado);
        
        btnCadastrar.setBounds(30,260,145,50);
        btnCadastrar.setFont(new Font("Montserrat",Font.BOLD,12));
        btnCadastrar.setIcon(cadastrar);
        add(btnCadastrar);
        
        btnActualizar.setBounds(185,260,145,50);
        btnActualizar.setFont(new Font("Montserrat",Font.BOLD,12));
        btnActualizar.setIcon(actualizar);
        add(btnActualizar);
        
        btnCancelar.setBounds(340,260,145,50);
        btnCancelar.setFont(new Font("Montserrat",Font.BOLD,12));
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
        setTitle("CADASTRAR ESPECIALIDADES");
        setSize(535,390);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public EspecialidadeMedView()
    {
        componente();
        tela();
    }
}
