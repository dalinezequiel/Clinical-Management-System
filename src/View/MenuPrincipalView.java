/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Dalin Ezequiel
 */
public class MenuPrincipalView extends JFrame 
{
    private JMenuBar bar;
    private JMenu admin,medico, enfermeiro,relatorio,config;
    private JMenuItem cadGeral,recepcao,servCli,cadMed,cadEnf,consulMed, consulEnf,tema,sobre,sair;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private ImageIcon medicoic, consultaic, medicamentoic,agendaic,laboratorioic,relatorioic,pacienteic,enfermeiraic,sairic;
    
    private void componente()
    {
        medicoic = new ImageIcon("image/medico.png");
        consultaic = new ImageIcon("image/consulta.png");
        medicamentoic = new ImageIcon("image/medicamento.png");
        agendaic = new ImageIcon("image/agenda.png");
        laboratorioic = new ImageIcon("image/laboratorio.png");
        relatorioic = new ImageIcon("image/relatorio.png");
        pacienteic = new ImageIcon("image/paciente.png");
        enfermeiraic = new ImageIcon("image/enfermeira.png");
        sairic = new ImageIcon("image/sair.png");
        
        bar = new JMenuBar();
        
        admin = new JMenu("ADMINISTRATIVO");
        admin.setFont(new Font("Montserrat",Font.PLAIN,12));
        cadGeral = new JMenuItem("Cadastro Geral");
        recepcao = new JMenuItem("Recepção");
        recepcao.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new RecepcaoView();
            }
        });
        servCli = new JMenuItem("Serviço Clínico");
        servCli.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaServicoClinicoView();
            }
        });
        
        admin.add(cadGeral);
        admin.add(recepcao);
        admin.add(servCli);
        bar.add(admin);
        
        medico = new JMenu("MÉDICO");
        medico.setFont(new Font("Montserrat",Font.PLAIN,12));
        cadMed = new JMenuItem("Cadastro");
        cadMed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaMedicoView();
            }
        });
        consulMed = new JMenuItem("Especialidade");
        consulMed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaEspecialidadeMedView();
            }
        });
        medico.add(cadMed);
        medico.add(consulMed);
        bar.add(medico);
        
        enfermeiro = new JMenu("ENFERMEIRO");
        enfermeiro.setFont(new Font("Montserrat",Font.PLAIN,12));
        cadEnf = new JMenuItem("Cadastro");
        cadEnf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaEnfermeiroView();
            }
        });
        consulEnf = new JMenuItem("Especialidade");
        consulEnf.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaEspecialidadeEnfView();
            }
        });
        enfermeiro.add(cadEnf);
        enfermeiro.add(consulEnf);
        bar.add(enfermeiro);
        
        relatorio = new JMenu("RELATÓRIOS");
        relatorio.setFont(new Font("Montserrat",Font.PLAIN,12));
        bar.add(relatorio);
        
        config = new JMenu("CONFIGURAÇÕES");
        config.setFont(new Font("Montserrat",Font.PLAIN,12));
        tema = new JMenuItem("Aparência");
        sobre = new JMenuItem("Sobre");
        sair = new JMenuItem("Sair");
        sair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int result = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair do sistema?","clínica",JOptionPane.YES_NO_OPTION);
                if(result == 0)
                {
                    System.exit(0);
                }
            }
        });
        config.add(tema);
        config.add(sobre);
        config.add(sair);
        bar.add(config);
        
        btn1 = new JButton("CONSULTA");
        btn2 = new JButton("MÉDICO");
        btn3 = new JButton("ENFERMEIRO");
        btn4 = new JButton("PACIENTE");
        btn5 = new JButton("LABORATÓRIO");
        btn6 = new JButton("AGENDA");
        btn7 = new JButton("MEDICAMENTO");
        btn8 = new JButton("SAIR");
          
        setJMenuBar(bar);
        btn1.setBounds(235,180,210,150);
        btn1.setFocusable(false);
        btn1.setIcon(consultaic);
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new RecepcaoView();
            }
        });
        add(btn1);
        
        btn2.setBounds(455,180,210,150);
        btn2.setFocusable(false);
        btn2.setIcon(medicoic);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaMedicoView();
            }
        });
        add(btn2);
        
        btn3.setBounds(675,180,210,150);
        btn3.setFocusable(false);
        btn3.setIcon(enfermeiraic);
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaEnfermeiroView();
            }
        });
        add(btn3);
        
        btn4.setBounds(895,180,210,150);
        btn4.setFocusable(false);
        btn4.setIcon(pacienteic);
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new ConsultaPacienteView();
            }
        });
        add(btn4);
        
        btn5.setBounds(235,340,210,150);
        btn5.setFocusable(false);
        btn5.setIcon(laboratorioic);
        add(btn5);
        
        btn6.setBounds(455,340,210,150);
        btn6.setFocusable(false);
        btn6.setIcon(agendaic);
        btn6.setAlignmentX(95);
        btn6.setAlignmentY(200);
        btn6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new AgendaView();
            }
        });
        add(btn6);
        
        btn7.setBounds(675,340,210,150);
        btn7.setIcon(medicamentoic);
        btn7.setFocusable(false);
        add(btn7);
        
        btn8.setBounds(895,340,210,150);
        btn8.setFocusable(false);
        btn8.setIcon(sairic);
        btn8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int result = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja sair do sistema?","clínica",JOptionPane.YES_NO_OPTION);
                if(result == 0)
                {
                    System.exit(0);
                }
            }
        });
        add(btn8);
    }
    private void tela()
    {
        setLayout(null);
        setTitle("SISTEMA DE GESTÃO CLÍNICA");
        setSize(410,495);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public MenuPrincipalView()
    {
        componente();
        tela();
    }
}
