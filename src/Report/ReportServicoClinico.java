/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Model.DAO.ConexaoSQL;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Dalin Ezequiel
 */
public class ReportServicoClinico {

    private JDialog f = new JDialog();
    private JPanel panel = new JPanel();
    private int code;
    private String servic;
    private String data;

    public void iReportPar() {
        try {
            HashMap map = new HashMap();
            map.put("codigoSc", code);
            map.put("servicoClinico", servic);
            map.put("dataRegisto", data);

            panel.removeAll();
            panel.repaint();
            panel.revalidate();

            JasperDesign jd = JRXmlLoader.load("report/ServicoClinicoPar.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint print = JasperFillManager.fillReport(jr, map, ConexaoSQL.getConnection());
            JRViewer visual = new JRViewer(print);
            panel.add(visual);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar gerar relatório.\n" + ex.getMessage(), "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void iReport() {
        try {
            
            panel.removeAll();
            panel.repaint();
            panel.revalidate();

            JasperDesign jd = JRXmlLoader.load("report/ServicoClinico.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint print = JasperFillManager.fillReport(jr, null, ConexaoSQL.getConnection());
            JRViewer visual = new JRViewer(print);
            panel.add(visual);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar gerar relatório.\n" + ex.getMessage(), "erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tela() {
        if ((code != 0) || (!servic.isEmpty()) || (!data.equals("1000-01-01"))) {
            iReportPar();
        }else
        {
            iReport();
        }
        panel.setLayout(new GridLayout(1, 1));
        f.add(panel);
        f.setModal(true);
        f.setFocusable(false);
        f.setTitle("SERVIÇO CLÍNICO");
        f.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

    public ReportServicoClinico(int codigo, String nome, String dat) {
        code = codigo;
        servic = nome;
        data = dat;
        iReport();
        tela();
    }

    public ReportServicoClinico() {
        iReport();
        tela();
    }
}
