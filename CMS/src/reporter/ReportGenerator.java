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

/**
 * Class used by Reporter, used to generate the report. Some fields used by iReport for the construction of the 
 * design template, e.g. the data source. The method public method generateMethod is the method used by external
 * classes.
 * @author Henrik
 *
 */
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
	
	/**
	 * The only constructor. Takes the path to the design template (.jrxml) and the wanted export path as parameters.
	 * @param designPath
	 * @param exportPath
	 * @throws FileNotFoundException
	 */
	public ReportGenerator(String designPath, String exportPath) throws FileNotFoundException {
		this.designPath = designPath;
		this.exportPath = exportPath;
		this.inputStream = new FileInputStream(designPath);
		parameters = new HashMap<String, Object>();
	}
	
	/**
	 * The public method used by other classes. Takes an arraylist of EmergencyCall as parameter.
	 * Creates a datasource for the construction of the design template, creates the report, and exports it to a pdf, 
	 * using the export path set in the constructor. Returns the export path as a string. 
	 * @param dataCollection
	 * @return
	 * @throws JRException
	 */
	public String generateReport(ArrayList<EmergencyCall> dataCollection) throws JRException {
		createDataSource(dataCollection);
		JasperPrint print = createReportInternal();
		exportReportToPdf(print);
		return exportPath;
	}
	
	/**
	 * Initializes the data source 
	 * @param dataCollection
	 */
	private void createDataSource(ArrayList<EmergencyCall> dataCollection) {
		dataSource = new JRBeanCollectionDataSource(dataCollection);
	}
	
	/**
	 * Generates the report using the design template and the data source. Returns an object of type JasperPrint
	 * @return JasperPrint
	 * @throws JRException
	 */
	private JasperPrint createReportInternal() throws JRException {
		JasperDesign jasperDesign = JRXmlLoader.load(inputStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		return jasperPrint;
	}
	
	/**
	 * Takes a JasperPrint as parameter, generates a pdf and returns the path to the report.
	 * @param report
	 * @throws JRException
	 */
	private void exportReportToPdf(JasperPrint report) throws JRException {
		JasperExportManager.exportReportToPdfFile(report, exportPath);
	}

}
