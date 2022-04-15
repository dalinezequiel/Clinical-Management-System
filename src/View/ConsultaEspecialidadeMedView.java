/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Dalin Ezequiel
 */
public class ConsultaEspecialidadeMedView extends JDialog
{
    private JTable tabela;
    private String [] coluna = {"CODIGO","ESPECIALIDADE","SALÁRIO","DATA REGISTO"};
    private JScrollPane scrol;
    private String data[][]={ {"101","Amit","10.000,00","14/01/2022 12:45:23"}}; 
    private JButton btnNovo, btnRemover, btnCancelar,btnPesquisa,btnRelatorio;
    private JLabel lbCodigo,lbEspecialidade;
    private JTextField txtCodigo,txtNome;
    private ImageIcon novo,remover,cancelar,pesquisa,relatorio;
    private void componente()
    {
        novo = new ImageIcon("image/novo.png");
        cancelar = new ImageIcon("image/exit.png");
        remover = new ImageIcon("image/remover.png");
        pesquisa = new ImageIcon("image/pesquisar.png");
        relatorio = new ImageIcon("image/rel.png");
        
        btnNovo = new JButton("NOVO");
        btnRemover = new JButton("REMOVER");
        btnCancelar = new JButton("CANCELAR");
        btnPesquisa = new JButton("PESQUISAR");
        btnRelatorio = new JButton("RELATÓRIO");
        
        lbCodigo = new JLabel("CÓDIGO");
        lbEspecialidade = new JLabel("ESPECIALIDADE");
        
        txtCodigo = new JTextField();
        txtNome = new JTextField();

        lbCodigo.setBounds(30,10,100,30);
        add(lbCodigo);
        txtCodigo.setBounds(30,35,100,30);
        txtCodigo.setFocusable(true);
        add(txtCodigo);
        
        lbEspecialidade.setBounds(140,10,100,30);
        add(lbEspecialidade);
        txtNome.setBounds(140,35,270,30);
        add(txtNome);
        
        btnPesquisa.setBounds(600,33,150,45);
        btnPesquisa.setFocusable(false);
        btnPesquisa.setIcon(pesquisa);
        add(btnPesquisa);
        
        btnNovo.setBounds(30,420,150,50);
        btnNovo.setFont(new Font("Montserrat",Font.BOLD,14));
        btnNovo.setIcon(novo);
        btnNovo.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               new EspecialidadeMedView();
           }
        });
        add(btnNovo);
        
        btnRemover.setBounds(190,420,150,50);
        btnRemover.setFont(new Font("Montserrat",Font.BOLD,14));
        btnRemover.setIcon(remover);
        add(btnRemover);
         
        btnRelatorio.setBounds(350,420,150,50);
        btnRelatorio.setFont(new Font("Montserrat",Font.BOLD,14));
        btnRelatorio.setIcon(relatorio);
        add(btnRelatorio);
        
        btnCancelar.setBounds(560,420,190,50);
        btnCancelar.setFont(new Font("Montserrat",Font.BOLD,14));
        btnCancelar.setIcon(cancelar);
        btnCancelar.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               dispose();
           }
        });
        add(btnCancelar);
       
        tabela=new JTable(data,coluna);
        tabela.setFont(new Font("Montserrat",Font.PLAIN,12));
        scrol = new JScrollPane(tabela);
        
        scrol.setBounds(30,100,720,300);
        add(scrol);
    }
    private void tela()
    {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("LISTA DE ESPECIALIDADES");
        setSize(800,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public ConsultaEspecialidadeMedView()
    {
        componente();
        tela();
    }
}
