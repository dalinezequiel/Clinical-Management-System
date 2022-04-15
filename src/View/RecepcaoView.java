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
public class RecepcaoView extends JDialog
{
    private JLabel lbCodigo,lbCodigoPaciente, lbNome, lbApelido,lbGenero,lbNascimento,lbDocumento,lbNrDocumento,
            lbEspecialidade,lbSalario,lbConsultorio,lbTelefone,lbEmail,lbProvincia,lbCidade,lbBairro,lbRua
            ,lbValor,lbData,lbHora,lbFormaPagamento,lbPai,lbMae;
    private JTextField txtCodigo,txtCodigoPaciente,txtNome, txtApelido,txtNascimento,txtDocumento, txtNrDocumento,
            txtSalario,txtTelefone,txtEmail,txtProvincia,txtCidade, txtBairro,txtRua,txtValor,txtData,txtHora,
            txtPai,txtMae;
    private JComboBox<String> boxGenero, boxDocumento, boxEspecialidade,boxConsultorio,boxProvincia,boxCidade,
            boxFormaPagamento;
    private JCheckBox rdEstado;
    private JButton btnCadastrar,btnActualizar,btnCancelar,btnPaciente,btnMedico,btnDoc;
    private ImageIcon cadastrar,actualizar,cancelar,doc;
    private int tamanhoFonteCaixaTexto;
    private DecimalFormat moeda;

    private void componente()
    {
        tamanhoFonteCaixaTexto = 14;
        moeda = new DecimalFormat("###.00");
        cancelar = new ImageIcon("image/exit.png");
        cadastrar = new ImageIcon("image/entrar.png");
        actualizar = new ImageIcon("image/actualizar.png");
        doc = new ImageIcon("image/rel.png");
        
        lbCodigo =  new JLabel("CÓDIGO");
        lbCodigoPaciente =  new JLabel("CÓD. PACIENTE");
        lbNome = new JLabel("NOME PACIENTE");
        lbApelido = new JLabel("MEDICO/ ENFERMEIRO");
        lbGenero = new JLabel("GÊNERO");
        lbNascimento = new JLabel("DATA NASCIMENTO");
        lbDocumento = new JLabel("IDENTIFICAÇÃO");
        lbNrDocumento = new JLabel("NR DOCUMENTO");
        lbEspecialidade = new JLabel("SERVIÇO CLÍNICO");
        lbSalario = new JLabel("SALÁRIO");
        lbConsultorio = new JLabel("CONSULTÓRIO");
        lbTelefone = new JLabel("TELEFONE");
        lbEmail = new JLabel("EMAIL");
        lbProvincia = new JLabel("PROVÍNCIA");
        lbCidade = new JLabel("CIDADE");
        lbBairro = new JLabel("BAIRRO");
        lbRua = new JLabel("RUA");
        lbValor = new JLabel("VALOR");
        lbData = new JLabel("DATA");
        lbHora = new JLabel("HORA");
        lbFormaPagamento = new JLabel("FORMA DE PAGAMENTO");
        lbPai = new JLabel("NOME DO PAI");
        lbMae = new JLabel("NOME DA MÃE");
        
        txtCodigo = new JTextField();
        txtCodigoPaciente = new JTextField();
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
        txtValor = new JTextField();
        txtData = new JTextField();
        txtHora = new JTextField();
        txtPai = new JTextField();
        txtMae = new JTextField();
        
        boxGenero = new JComboBox<String>();
        boxDocumento = new JComboBox<String>();
        boxEspecialidade = new JComboBox<String>();
        boxConsultorio = new JComboBox<String>();
        boxProvincia = new JComboBox<String>();
        boxCidade = new JComboBox<String>();
        boxFormaPagamento = new JComboBox<String>();
        
        rdEstado = new JCheckBox("Agendar a Consulta?");
        
        btnCadastrar = new JButton("CONFIRMAR");
        btnActualizar = new JButton("ALTERAR");
        btnDoc = new JButton("COMPROVATIVO");
        btnCancelar = new JButton("CANCELAR");
        
        btnPaciente = new JButton(":::");
        btnMedico = new JButton(":::");
        
        lbCodigo.setBounds(50,25,100,30);
        add(lbCodigo);
        txtCodigo.setBounds(50,50,100,30);
        txtCodigo.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtCodigo);
        
        lbCodigoPaciente.setBounds(160,25,100,30);
        add(lbCodigoPaciente);
        txtCodigoPaciente.setBounds(160,50,100,30);
        txtCodigoPaciente.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtCodigoPaciente);
        
        btnPaciente.setBounds(475,50,50,30);
        btnPaciente.setFont(new Font("Montserrat",Font.BOLD,14));
        btnPaciente.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               new ConsultaPacienteView();
           }
        });
        add(btnPaciente);
        
        lbNome.setBounds(270,25,100,30);
        add(lbNome);
        txtNome.setBounds(270,50,200,30);
        txtNome.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtNome);
        
        lbApelido.setBounds(540,25,200,30);
        add(lbApelido);
        txtApelido.setBounds(540,50,250,30);
        txtApelido.setFont(new Font("Montserrat",Font.BOLD,tamanhoFonteCaixaTexto));
        add(txtApelido);
        
        btnMedico.setBounds(795,50,50,30);
        btnMedico.setFont(new Font("Montserrat",Font.BOLD,14));
        btnMedico.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               new ConsultaMedicoView();
           }
        });
        add(btnMedico);
        
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
        boxDocumento.setBounds(430,105,220,30);
        add(boxDocumento);
        
        lbNrDocumento.setBounds(670,80,100,30);
        add(lbNrDocumento);
        txtNrDocumento.setBounds(670,105,175,30);
        add(txtNrDocumento);
        /*lbNrDocumento.setBounds(50,135,100,30);
        add(lbNrDocumento);
        txtNrDocumento.setBounds(50,160,180,30);
        add(txtNrDocumento);*/
        
        lbEspecialidade.setBounds(50,135,150,30);
        add(lbEspecialidade);
        boxEspecialidade.setBounds(50,160,320,30);
        add(boxEspecialidade);
        
        lbValor.setBounds(380,135,150,30);
        add(lbValor);
        txtValor.setBounds(380,160,150,30);
        txtValor.setText(moeda.format(Double.parseDouble("0")));
        txtValor.setFont(new Font("Montserrat",Font.BOLD,16));
        add(txtValor);
        
        lbFormaPagamento.setBounds(550,135,200,30);
        add(lbFormaPagamento);
        boxFormaPagamento.setBounds(550,160,294,30);
        add(boxFormaPagamento);
        
        /*lbConsultorio.setBounds(500,195,100,30);
        add(lbConsultorio);
        boxConsultorio.setBounds(500,220,120,30);
        add(boxConsultorio);*/
        
        lbTelefone.setBounds(50,195,100,30);
        add(lbTelefone);
        txtTelefone.setBounds(50,220,160,30);
        add(txtTelefone);
        
        lbEmail.setBounds(230,195,100,30);
        add(lbEmail);
        txtEmail.setBounds(230,220,250,30);
        add(txtEmail);
        
        lbProvincia.setBounds(50,255,100,30);
        add(lbProvincia);
        boxProvincia.setBounds(50,280,200,30);
        add(boxProvincia);
        
        lbCidade.setBounds(270,255,100,30);
        add(lbCidade);
        boxCidade.setBounds(270,280,200,30);
        add(boxCidade);
        
        lbBairro.setBounds(490,255,100,30);
        add(lbBairro);
        txtBairro.setBounds(490,280,130,30);
        add(txtBairro);
        
        lbRua.setBounds(640,255,100,30);
        add(lbRua);
        txtRua.setBounds(640,280,205,30);
        add(txtRua);
        
        rdEstado.setBounds(340,340,170,30);
        rdEstado.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e)
           {
               if(rdEstado.isSelected())
               {
                   txtData.setEnabled(true);
                   txtHora.setEnabled(true);
               }else
               {
                   txtData.setEnabled(false);
                   txtHora.setEnabled(false);
               }
           }
        });
        add(rdEstado);
        
        lbData.setBounds(50,315,100,30);
        add(lbData);
        txtData.setBounds(50,340,150,30);
        txtData.setFont(new Font("Montserrat",Font.BOLD,16));
        txtData.setEnabled(false);
        add(txtData);
        
        lbHora.setBounds(220,315,100,30);
        add(lbHora);
        txtHora.setBounds(220,340,100,30);
        txtHora.setFont(new Font("Montserrat",Font.BOLD,16));
        txtHora.setEnabled(false);
        add(txtHora);
        
        lbPai.setBounds(50,375,200,30);
        add(lbPai);
        txtPai.setBounds(50,400,290,30);
        txtPai.setFont(new Font("Montserrat",Font.BOLD,16));
        add(txtPai);
        
        lbMae.setBounds(360,375,200,30);
        add(lbMae);
        txtMae.setBounds(360,400,290,30);
        txtMae.setFont(new Font("Montserrat",Font.BOLD,16));
        add(txtMae);
        
        btnCadastrar.setBounds(50,480,180,50);
        btnCadastrar.setFont(new Font("Montserrat",Font.BOLD,14));
        btnCadastrar.setIcon(cadastrar);
        add(btnCadastrar);
        
        btnActualizar.setBounds(240,480,180,50);
        btnActualizar.setFont(new Font("Montserrat",Font.BOLD,14));
        btnActualizar.setIcon(actualizar);
        add(btnActualizar);
        
        btnDoc.setBounds(430,480,200,50);
        btnDoc.setFont(new Font("Montserrat",Font.BOLD,14));
        btnDoc.setIcon(doc);
        add(btnDoc);
        
        btnCancelar.setBounds(665,480,180,50);
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
        setTitle("RECEPÇÃO AO PACIENTE");
        setSize(920,630);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public RecepcaoView()
    {
        componente();
        tela();
    }
}
