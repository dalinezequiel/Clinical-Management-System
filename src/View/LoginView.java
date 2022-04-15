/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.DAO.LoginSQL;
import Model.PerfilModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 *
 * @author Dalin Ezequiel
 */
public class LoginView extends JFrame {

    private JLabel lblImage;
    private ImageIcon image, entrar, sair;
    private JLabel lblPerfil;
    private JComboBox<String> boxPerfil;
    private JLabel lblUsuario;
    private JLabel lblSenha;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnSair;
    private JButton btnEntrar;
    private JLabel direito;
    
    private ArrayList<PerfilModel> listPerfil = null;

    private void componente() {
        sair = new ImageIcon("image/exit.png");
        entrar = new ImageIcon("image/entrar.png");

        image = new ImageIcon("image/log.png");
        lblImage = new JLabel();
        lblImage.setIcon(image);
        lblImage.setBounds(130, 20, 128, 128);
        add(lblImage);

        lblPerfil = new JLabel("PERFIL");
        lblPerfil.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblPerfil.setBounds(65, 150, 50, 30);
        add(lblPerfil);

        boxPerfil = new JComboBox<String>();
        boxPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        boxPerfil.setBounds(65, 175, 260, 35);
        listPerfil = LoginSQL.retornaPerfil();
        for(int i=0; i<listPerfil.size(); i++)
        {
            boxPerfil.addItem(listPerfil.get(i).getPerfil().toUpperCase());
        }
        add(boxPerfil);

        lblUsuario = new JLabel("USUÁRIO");
        lblUsuario.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblUsuario.setBounds(65, 210, 90, 30);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        txtUsuario.setBounds(65, 235, 260, 40);
        add(txtUsuario);

        lblSenha = new JLabel("SENHA");
        lblSenha.setFont(new Font("Montserrat", Font.BOLD, 12));
        lblSenha.setBounds(65, 270, 90, 30);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setEchoChar('●');
        txtSenha.setFont(new Font("Montserrat", Font.PLAIN, 12));
        txtSenha.setBounds(65, 295, 260, 40);
        add(txtSenha);

        btnSair = new JButton("SAIR");
        btnSair.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnSair.setIcon(sair);
        btnSair.setBounds(65, 350, 115, 60);
        add(btnSair);
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnEntrar = new JButton("ENTRAR");
        btnEntrar.setFont(new Font("Montserrat", Font.BOLD, 14));
        btnEntrar.setIcon(entrar);
        btnEntrar.setBounds(190, 350, 135, 60);
        add(btnEntrar);
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean r = LoginSQL.consultaByUsername(String.valueOf(boxPerfil.getSelectedItem()),txtUsuario.getText(), txtSenha.getText());
                if (r) {
                    new MenuPrincipalView();
                    setVisible(false);
                }
            }
        });
        direito = new JLabel("©2022.Todos direitos reservados.");
        direito.setBounds(110, 400, 200, 30);
        direito.setForeground(Color.DARK_GRAY);
        direito.setEnabled(false);
        //add(direito);
    }

    private void tela() {
        setLayout(null);
        setTitle("Login");
        setSize(400, 510);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public LoginView() {
        componente();
        tela();
    }
}
