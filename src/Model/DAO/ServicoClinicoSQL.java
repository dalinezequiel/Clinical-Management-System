/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.ServicoClinicoModel;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalin Ezequiel
 */
public class ServicoClinicoSQL {

    private static Connection con = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    private static ArrayList<ServicoClinicoModel> listSc = null;
    private static ServicoClinicoModel sc = null;

    public static void cadastroAll(ServicoClinicoModel scm) {
        try {
            String insert = "INSERT INTO servicoclinico(Codigo,ServicoClinico,valor,estado,dataRegisto)values(?,?,?,?,?)";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(insert);

            pst.setInt(1, scm.getCodigo());
            pst.setString(2, scm.getServicoClinico());
            pst.setDouble(3, scm.getValor());
            pst.setString(4, scm.getEstado());
            pst.setDate(5, scm.getDataRegisto());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Serviço clinico cadastrado com sucesso!", "serviço clinico", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar o serviço clinico.\n" + e.getMessage(), "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<ServicoClinicoModel> consultaClinicaAll() {
        listSc = new ArrayList<ServicoClinicoModel>();
        try {
            String select = "SELECT * from servicoClinico";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(select);
            rs = pst.executeQuery();

            while (rs.next()) {
                sc = new ServicoClinicoModel();
                sc.setCodigo(rs.getInt("Codigo"));
                sc.setServicoClinico(rs.getString("ServicoClinico"));
                sc.setValor(rs.getDouble("Valor"));
                sc.setEstado(rs.getString("Estado"));
                sc.setDataRegisto(rs.getDate("DataRegisto"));
                listSc.add(sc);
            }
            //JOptionPane.showMessageDialog(null, "Serviços lidos com sucesso!", "leitura", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura.\n" + e.getMessage(), "leitura", JOptionPane.ERROR_MESSAGE);
        }
        return listSc;
    }

    public static void populaServicoClinico(DefaultTableModel tb) {
        listSc = consultaClinicaAll();
        tb.setRowCount(0);

        Object[] row = new Object[5];
        for (int i = 0; i < listSc.size(); i++) {
            row[0] = String.valueOf(listSc.get(i).getCodigo());
            row[1] = listSc.get(i).getServicoClinico();
            row[2] = listSc.get(i).getValor();
            row[3] = listSc.get(i).getEstado();
            row[4] = listSc.get(i).getDataRegisto();
            tb.addRow(row);
        }
    }

    public static void deleteById(int codigo) {
        try {
            String deleteQuery = "DELETE FROM servicoClinico WHERE Codigo = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(deleteQuery);
            pst.setInt(1, codigo);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Serviços clínico excluído com sucesso!", "exclusão", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura.\n" + e.getMessage(), "leitura", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizaAll(ServicoClinicoModel sc) {
        try {
            String updateQuery = "UPDATE ServicoClinico SET ServicoClinico = ?, Valor = ?, Estado = ? WHERE codigo = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(updateQuery);

            pst.setString(1, sc.getServicoClinico());
            pst.setDouble(2, sc.getValor());
            pst.setString(3, sc.getEstado());
            pst.setInt(4, sc.getCodigo());

            pst.executeUpdate();
            pst.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Serviço clínico actualizado com sucesso!", "actualização", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de actualização.\n" + e.getMessage(), "actualização", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<ServicoClinicoModel> pesquisaAll(int codigo, String nome,String data) {
        listSc = new ArrayList<ServicoClinicoModel>();
        try {
            String select = "SELECT * FROM ServicoClinico WHERE Codigo = ? OR servicoClinico = ? OR DataRegisto = ?"; 
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(select);
            pst.setInt(1, codigo);
            pst.setString(2, nome);
            pst.setDate(3, Date.valueOf(data));
            
            rs = pst.executeQuery();

            while (rs.next()) {
                sc = new ServicoClinicoModel();
                sc.setCodigo(rs.getInt("Codigo"));
                sc.setServicoClinico(rs.getString("ServicoClinico"));
                sc.setValor(rs.getDouble("Valor"));
                sc.setEstado(rs.getString("Estado"));
                sc.setDataRegisto(rs.getDate("DataRegisto"));
                listSc.add(sc);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura.\n" + e.getMessage(), "leitura", JOptionPane.ERROR_MESSAGE);
        }
        return listSc;
    }
    public static void populaPesquisaAll(DefaultTableModel tb, int codigo, String nome, String data) {
        listSc = pesquisaAll(codigo, nome, data);
        tb.setRowCount(0);

        Object[] row = new Object[5];
        for (int i = 0; i < listSc.size(); i++) {
            row[0] = String.valueOf(listSc.get(i).getCodigo());
            row[1] = listSc.get(i).getServicoClinico();
            row[2] = listSc.get(i).getValor();
            row[3] = listSc.get(i).getEstado();
            row[4] = listSc.get(i).getDataRegisto();
            tb.addRow(row);
        }
    }
}
