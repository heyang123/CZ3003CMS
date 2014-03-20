package reporter;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class ReportGenerator {
	
	private JRBeanCollectionDataSource dataSource;
	private String exportPath, designPath;
	private InputStream inputStream;
	private Map<String, Object> parameters;
	
	public void setDataSource(JRBeanCollectionDataSource dataSource) {
		this.dataSource = dataSource;
	}
	public String getExportPath() {
		return exportPath;
	}
	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}
	public String getDesignPath() {
		return designPath;
	}
	public void setDesignPath(String designPath) {
		this.designPath = designPath;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	public ReportGenerator(String designPath, String exportPath) throws FileNotFoundException {
		this.designPath = designPath;
		this.exportPath = exportPath;
		this.inputStream = new FileInputStream(designPath);
		parameters = new HashMap<String, Object>();
	}
	
	public String generateReport(ArrayList<EmergencyCall> dataCollection) throws JRException {
		createDataSource(dataCollection);
		JasperPrint print = createReportInternal();
		exportReportToPdf(print);
		return exportPath;
	}
	
	private void createDataSource(ArrayList<EmergencyCall> dataCollection) {
		dataSource = new JRBeanCollectionDataSource(dataCollection);
	}
	
	private JasperPrint createReportInternal() throws JRException {
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return jasperPrint;
	}
	
	private void exportReportToPdf(JasperPrint report) throws JRException {
		JasperExportManager.exportReportToPdfFile(report, exportPath);
	}

}
