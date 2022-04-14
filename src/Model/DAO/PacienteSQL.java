/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.*;
import javax.swing.JOptionPane;
import Model.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dalin Ezequiel
 */
public class PacienteSQL {

    private static PreparedStatement pst = null;
    private static Connection con = null;
    private static ResultSet rs = null;
    private static PacienteModel pt;
    private static ArrayList<PacienteModel> lista = null;

    public void cadastroAll(Connection con, PreparedStatement pst, PacienteModel pm) {
        try {
            String sql = "INSERT INTO paciente(IDPaciente, Nome, Apelido,Genero, Documento, NrDocumento) VALUES (?,?,?,?,?,?)";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, pm.getIDPaciente());
            pst.setString(2, pm.getNome());
            pst.setString(3, pm.getApelido());
            pst.setString(4, pm.getGenero());
            pst.setString(5, pm.getIdentificao());
            pst.setString(6, pm.getNrDocumento());
            
            pst.execute();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cadastrar!\n"+e.getMessage(),"cadastro",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ArrayList<PacienteModel> consultaPacienteAll() {
        lista = new ArrayList<PacienteModel>();
        try {
            String sql = "SELECT IDPaciente,Nome,Apelido,Genero,Documento,NrDocumento FROM paciente";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                pt = new PacienteModel();
                pt.setIDPaciente(rs.getInt("IDPaciente"));
                pt.setNome(rs.getString("Nome"));
                pt.setApelido(rs.getString("Apelido"));
                pt.setGenero(rs.getString("Genero"));
                pt.setIdentificao(rs.getString("Documento"));
                pt.setNrDocumento(rs.getString("NrDocumento"));
                
                lista.add(pt);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura!\n"+e.getMessage(),"consulta",JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    public static void populaPaciente(DefaultTableModel tb) {
        lista = consultaPacienteAll();
        tb.setRowCount(0);

        Object[] row = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = String.valueOf(lista.get(i).getIDPaciente());
            row[1] = lista.get(i).getNome();
            row[2] = lista.get(i).getApelido();
            row[3] = lista.get(i).getGenero();
            row[4] = lista.get(i).getIdentificao();
            row[5] = lista.get(i).getNrDocumento();
            tb.addRow(row);
        }
    }

    public static ArrayList<PacienteModel> pesquisaPacienteAll(int codigo, String nome) {
        lista = new ArrayList<PacienteModel>();
        try {
            String sql = "SELECT IDPaciente,Nome,Apelido,Genero,Documento,NrDocumento FROM paciente WHERE IDPaciente = ? OR Nome = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, codigo);
            pst.setString(2, nome);
            rs = pst.executeQuery();

            while (rs.next()) {
                pt = new PacienteModel();
                pt.setIDPaciente(rs.getInt("IDPaciente"));
                pt.setNome(rs.getString("Nome"));
                pt.setApelido(rs.getString("Apelido"));
                pt.setGenero(rs.getString("Genero"));
                pt.setIdentificao(rs.getString("Documento"));
                pt.setNrDocumento(rs.getString("NrDocumento"));
                
                lista.add(pt);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura!\n"+e.getMessage(),"consulta",JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public static void populapesquisaPacienteAll(DefaultTableModel tb, int codigo, String nome) {
        lista = pesquisaPacienteAll(codigo, nome);
        tb.setRowCount(0);

        Object[] row = new Object[6];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = String.valueOf(lista.get(i).getIDPaciente());
            row[1] = lista.get(i).getNome();
            row[2] = lista.get(i).getApelido();
            row[3] = lista.get(i).getGenero();
            row[4] = lista.get(i).getIdentificao();
            row[5] = lista.get(i).getNrDocumento();
            tb.addRow(row);
        }
    }
    public ArrayList<PacienteModel> consultaById(int codigo) {
        pt = new PacienteModel();
        lista = new ArrayList<PacienteModel>();
        try {
            String sql = "SELECT * FROM paciente WHERE IDPaciente = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);

            rs = pst.executeQuery();

            while (rs.next()) {
                pt.setIDPaciente(rs.getInt("IDPaciente"));
                pt.setNome(rs.getString("Nome"));
                pt.setApelido(rs.getString("Apelido"));
                pt.setGenero(rs.getString("Genero"));
                pt.setIdentificao(rs.getString("Documento"));
                pt.setNrDocumento(rs.getString("NrDocumento"));
                
                lista.add(pt);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura!\n"+e.getMessage(),"consulta",JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public ArrayList<PacienteModel> consultaByName(String nome) {
        pt = new PacienteModel();
        lista = new ArrayList<PacienteModel>();
        try {
            String sql = "SELECT * FROM paciente WHERE Nome = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            
            rs = pst.executeQuery();

            while (rs.next()) {
                pt.setIDPaciente(rs.getInt("IDPaciente"));
                pt.setNome(rs.getString("Nome"));
                pt.setApelido(rs.getString("Apelido"));
                pt.setGenero(rs.getString("Genero"));
                pt.setIdentificao(rs.getString("Documento"));
                pt.setNrDocumento(rs.getString("NrDocumento"));
                
                lista.add(pt);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro de leitura!\n"+e.getMessage(),"consulta",JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }
    
    public static void deleteById(int codigo) {
        try {
            String sql = "DELETE FROM paciente WHERE IDPaciente = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover!\n"+e.getMessage(),"remoção",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void actualizaById(PacienteModel pm) {
        try {
            String sql = "UPDATE paciente set Nome = ?, Apelido = ?,Genero = ?, Documento = ?,NrDocumento = ? WHERE IDPaciente = ?";
            con = ConexaoSQL.getConnection();
            pst = con.prepareStatement(sql);
            
            pst.setString(1, pm.getNome());
            pst.setString(2, pm.getApelido());
            pst.setString(3, pm.getGenero());
            pst.setString(4, pm.getIdentificao());
            pst.setString(5, pm.getNrDocumento());
            pst.setInt(6, pm.getIDPaciente());
            
            pst.executeUpdate();
            pst.close();
            
            JOptionPane.showMessageDialog(null, "Paciente actualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao actualizar!\n"+e.getMessage(),"actualizar",JOptionPane.ERROR_MESSAGE);
        }
    }
}
