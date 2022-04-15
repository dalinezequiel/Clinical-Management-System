/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.DistritoModel;
import Model.DocumentoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalin Ezequiel
 */
public class DistritoSQL 
{
    private static PreparedStatement pst = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static ArrayList<DistritoModel> listaDistrito;
    private static DistritoModel dm;
    
    public static ArrayList<DistritoModel> retornaDistrito(int codigo) {
        listaDistrito = new ArrayList<DistritoModel>();
        try {
            String sql = "SELECT * FROM distrito Where codigo = ?";
            con = ConexaoSQL.getConnection();
            
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            rs = pst.executeQuery();

            while (rs.next()) {
                dm = new DistritoModel();
                dm.setCodigo(rs.getInt("Codigo"));
                dm.setDistrito(rs.getString("Distrito"));
                
                listaDistrito.add(dm);
            }
            rs.close();
            pst.close();
            //JOptionPane.showMessageDialog(null, "Distritos lidos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura!\n"+e.getMessage(),"consulta",JOptionPane.ERROR_MESSAGE);
        }
        return listaDistrito;
    } 
}
