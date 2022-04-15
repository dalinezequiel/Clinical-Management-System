/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.LoginModel;
import Model.PacienteModel;
import Model.PerfilModel;
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
public class LoginSQL {

    private static PreparedStatement pst = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static ArrayList<LoginModel> listaLogin = null;
    private static LoginModel lm;
    private static ArrayList<PerfilModel> listaPerfil = null;
    private static PerfilModel pm;

    public static boolean consultaByUsername(String perfil, String usuario, String senha) {
        lm = new LoginModel();
        listaLogin = new ArrayList<LoginModel>();
        try {
            String sql = "SELECT * FROM login WHERE Perfil = ? AND usuario = ? AND senha = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, perfil);
            pst.setString(2, usuario);
            pst.setString(3, senha);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Acesso permitido!", "login", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Acesso negado!", "login", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de execução.\n"+e.getMessage(), "erro", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
     public static ArrayList<PerfilModel> retornaPerfil() {
        listaPerfil = new ArrayList<PerfilModel>();
        try {
            String sql = "SELECT * FROM perfil";
            con = ConexaoSQL.getConnection();
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                pm = new PerfilModel();
                pm.setCodigo(rs.getInt("Codigo"));
                pm.setPerfil(rs.getString("Perfil"));
                
                listaPerfil.add(pm);
            }
            rs.close();
            pst.close();
            //JOptionPane.showMessageDialog(null, "Perfis lidos com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura!\n"+e.getMessage(),"consulta",JOptionPane.ERROR_MESSAGE);
        }
        return listaPerfil;
    }
}
