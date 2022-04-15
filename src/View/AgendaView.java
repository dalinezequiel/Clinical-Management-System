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
public class AgendaView extends JDialog
{
    private JTable tabela;
    private String [] coluna = {"CODIGO","NOME","APELIDO"};
    private JScrollPane scrol;
    private String data[][]={ {"101","Amit","670000"}}; 
    private JButton btnNovo, btnRemover, btnCancelar,btnPesquisa,btnRelatorio,btnEspecialidade;
    private JLabel lbCodigo,lbNome,lbEspecialidade;
    private JTextField txtCodigo,txtNome;
    private JComboBox<String> boxEspecialidade;
    private ImageIcon novo,remover,cancelar,pesquisa,relatorio,especialidade;
    
    private void componente()
    {
        novo = new ImageIcon("image/novo.png");
        cancelar = new ImageIcon("image/exit.png");
        remover = new ImageIcon("image/remover.png");
        pesquisa = new ImageIcon("image/pesquisar.png");
        relatorio = new ImageIcon("image/rel.png");
        especialidade = new ImageIcon("image/especialidade.png");
        
        btnNovo = new JButton("NOVA");
        btnRemover = new JButton("REMOVER");
        btnCancelar = new JButton("CANCELAR");
        btnPesquisa = new JButton("PESQUISAR");
        btnRelatorio = new JButton("RELATÓRIO");
        btnEspecialidade = new JButton("ATENDER PACIENTE");
        
        lbCodigo = new JLabel("CÓDIGO");
        lbNome = new JLabel("NOME");
        lbEspecialidade = new JLabel("ESPECIALIDADE");
        
        txtCodigo = new JTextField();
        txtNome = new JTextField();
        
        boxEspecialidade = new JComboBox<String>();
        
        lbCodigo.setBounds(50,50,100,30);
        add(lbCodigo);
        txtCodigo.setBounds(50,75,100,30);
        txtCodigo.setFocusable(true);
        add(txtCodigo);
        
        lbNome.setBounds(160,50,100,30);
        add(lbNome);
        txtNome.setBounds(160,75,220,30);
        add(txtNome);
        
        /*lbEspecialidade.setBounds(390,50,100,30);
        add(lbEspecialidade);
        boxEspecialidade.setBounds(390,75,280,30);
        add(boxEspecialidade);*/
        
        btnPesquisa.setBounds(825,65,170,50);
        btnPesquisa.setFocusable(false);
        btnPesquisa.setIcon(pesquisa);
        add(btnPesquisa);
        
        btnNovo.setBounds(50,550,150,55);
        btnNovo.setFont(new Font("Montserrat",Font.BOLD,14));
        btnNovo.setIcon(novo);
        btnNovo.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               new RecepcaoView();
           }
        });
        add(btnNovo);
        
        btnRemover.setBounds(220,550,150,55);
        btnRemover.setFont(new Font("Montserrat",Font.BOLD,14));
        btnRemover.setIcon(remover);
        add(btnRemover);
         
        btnRelatorio.setBounds(390,550,150,55);
        btnRelatorio.setFont(new Font("Montserrat",Font.BOLD,14));
        btnRelatorio.setIcon(relatorio);
        add(btnRelatorio);
        
        btnEspecialidade.setBounds(560,550,220,55);
        btnEspecialidade.setFont(new Font("Montserrat",Font.BOLD,14));
        //btnEspecialidade.setIcon(especialidade);
        btnEspecialidade.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               //new ConsultaEspecialidadeView();
           }
        });
        add(btnEspecialidade);
        
        btnCancelar.setBounds(850,550,150,55);
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
        
        scrol.setBounds(50,130,950,400);
        add(scrol);
    }
    private void tela()
    {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("AGENDA");
        setSize(1070,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public AgendaView()
    {
        componente();
        tela();
    }
}
