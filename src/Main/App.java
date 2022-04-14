/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import View.*;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author Dalin Ezequiel
 */
import Util.*;
public class App 
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            new LoginView();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    } 
}
