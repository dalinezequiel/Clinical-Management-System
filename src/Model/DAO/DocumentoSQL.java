/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.DocumentoModel;
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
public class DocumentoSQL 
{
    private static PreparedStatement pst = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static ArrayList<DocumentoModel> listaDocumento;
    private static DocumentoModel dm;
    
    public static ArrayList<DocumentoModel> retornaDocumento() {
        listaDocumento = new ArrayList<DocumentoModel>();
        try {
            String sql = "SELECT * FROM documento";
            con = ConexaoSQL.getConnection();
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                dm = new DocumentoModel();
                dm.setCodigo(rs.getInt("Codigo"));
                dm.setDocumento(rs.getString("Documento"));
                
                listaDocumento.add(dm);
            }
            rs.close();
            pst.close();
            //JOptionPane.showMessageDialog(null, "Documentos lidos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listaDocumento;
    }
}
