/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.GeneroModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalin Ezequiel
 */
public class GeneroSQL 
{
    private static PreparedStatement pst = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static ArrayList<GeneroModel> listaGenero = null;
    private static GeneroModel gm;
    
    public static ArrayList<GeneroModel> retornaGenero() {
        listaGenero = new ArrayList<GeneroModel>();
        try {
            String sql = "SELECT * FROM genero";
            con = ConexaoSQL.getConnection();
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                gm = new GeneroModel();
                gm.setCodigo(rs.getInt("Codigo"));
                gm.setGenero(rs.getString("Genero"));
                
                listaGenero.add(gm);
            }
            rs.close();
            pst.close();
            //JOptionPane.showMessageDialog(null, "Generos lidos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaGenero;
    }
}
