/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Dalin Ezequiel
 */
public class TemaView extends JDialog
{
    private ImageIcon image,imgNimbus, imgWindows;
    private JLabel lbTema, lbImage;
    private JComboBox<String> boxTema;
    private JButton btnAplicar, btnCancelar;
    
    public void componente()
    {
        image = new ImageIcon("image/padrao.png");
        imgNimbus = new ImageIcon("image/nimbus.png");
        imgWindows = new ImageIcon("image/windows.png");
        
        //Image imgPadrao = (image).getImage().getScaledInstance(lbImage.getWidth(), lbImage.getHeight(), Image.SCALE_SMOOTH);
        //image = new ImageIcon(imgPadrao);
        
        lbTema = new JLabel("ESCOLHA O TEMA");
        lbImage = new JLabel();
        boxTema = new JComboBox<String>();
        btnAplicar = new JButton("APLICAR");
        btnCancelar = new JButton("CANCELAR");
        
        lbTema.setBounds(25,20,150,30);
        add(lbTema);
        boxTema.setBounds(25,50,250,30);
        add(boxTema);
        boxTema.addItem("Padrão");
        boxTema.addItem("Nimbus");
        boxTema.addItem("Windows");
        boxTema.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(boxTema.getSelectedItem().equals("Nimbus"))
                {
                    lbImage.setIcon(imgNimbus);
                }else if(boxTema.getSelectedItem().equals("Windows"))
                {
                    lbImage.setIcon(imgWindows);
                }else
                {
                    lbImage.setIcon(image);
                }
            }
        });
        
        lbImage.setBounds(25,100,1000,455);
        lbImage.setHorizontalAlignment(JLabel.CENTER);
        lbImage.setVerticalAlignment(JLabel.CENTER);
        lbImage.setIcon(image);
        add(lbImage);
        
        btnAplicar.setBounds(750,570,135,45);
        add(btnAplicar);
        
        btnCancelar.setBounds(895,570,130,45);
        add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
    }
     private void tela() {
        setLayout(null);
        setModal(true);
        setFocusable(false);
        setTitle("LISTA DE PACIENTES");
        setSize(1070, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
     public TemaView()
     {
         componente();
         tela();
     }
}
