/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.ProvinciaModel;
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
public class ProvinciaSQL 
{
    private static PreparedStatement pst = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static ArrayList<ProvinciaModel> listaProvincia = null;
    private static ProvinciaModel pm ;

    public static ArrayList<ProvinciaModel> retornaProvincia() {
        listaProvincia = new ArrayList<ProvinciaModel>();
        try {
            String sql = "SELECT * FROM provincia";
            con = ConexaoSQL.getConnection();
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                pm = new ProvinciaModel();
                pm.setCodigo(rs.getInt("Codigo"));
                pm.setProvincia(rs.getString("Provincia"));
                
                listaProvincia.add(pm);
            }
            rs.close();
            pst.close();
            //JOptionPane.showMessageDialog(null, "Provincias lidas com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaProvincia;
    } 
}
