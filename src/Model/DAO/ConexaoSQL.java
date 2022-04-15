/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalin Ezequiel
 */
public class ConexaoSQL 
{
    public static Connection getConnection()
    {
        Connection conexao=null;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3307/clinica";
        String user="root";
        String password="hund,70";
        
        try
        {
            Class.forName(driver);
            conexao=DriverManager.getConnection(url, user, password);
            return conexao;
        }catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Classe nao encontrada");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
         return null;
    }
}
