package com.j2ee.java.report;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;

import com.j2ee.java.model.dao.HibernateUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ProductReportDAO {
	
	private Map<String, Object>params = new HashMap<String, Object>();
	private Date date = new Date();
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YY:HH.mm.ss");
	static SessionFactory session = HibernateUtil.getSessionFactory();
	
	public Session getOpenSession(){
		
		return session.openSession();
	}
	
	public void runReport(String path, String fileName) {//GEN-FIRST:event_jxBtnReviewActionPerformed
    	Session s = this.getOpenSession();
    	params.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, s);
        params.put("@CustomerName", "Sang Le Duc");  
        params.put("@Description", "Product List");
        //
        //String filePath = "pdf\\" + fileName + dateFormat.format(date.getTime()) + ".pdf";
		String filePath = fileName;
        try {
			
				JasperReport reportFile = JasperCompileManager.compileReport(path);
				JasperPrint jPrint = JasperFillManager.fillReport(reportFile, params);
				JasperViewer.viewReport(jPrint, false);
				JasperExportManager.exportReportToPdfFile(jPrint, filePath);
            	
                //
                //InputStream input = this.getClass().getResource("/report/rptCurrentlySubjectOpen.jrxml").openStream();
                //JasperDesign design = JRXmlLoader.load(input);
                //java.sql.Connection _conn = new java.sql.Connection();
                //JasperReport jr = JasperCompileManager.compileReport(design);

    //            FileInputStream fis = new FileInputStream(this.getClass().getResource("/mnstudent/presentationlayer/report/rptCurrentRegistrationCourses.jasper").getPath());
    //            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
    //            JasperReport jr = (JasperReport) JRLoader.loadObject(bufferedInputStream);

                //
                

               //JasperPrint jasperPrint = JasperFillManager.fillReport(jr, params);
               // JasperViewer jasperView = new JasperViewer(jasperPrint, false);
               // jasperView.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(ProductReportDAO.class.getName()).log(Level.ERROR, null, ex);

            }/* catch (IOException ex) {
                Logger.getLogger(ProductReport.class.getName()).log(Level.ERROR, null, ex);
            }*/
	}
}
