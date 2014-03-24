package reporter;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import net.sf.jasperreports.engine.JRException;
/**
 * The class to be used by external actors. Consists of a constructor, getter and setter
 *  and the important method generateReport. The constructor takes the path of the compiled design template and
 *  the wanted exportPath as parameters. 
 * @author Henrik
 *
 */
public class Reporter {
	
	private ReportData data;
	private ReportGenerator reportGenerator;

	/**
	 * The only contructor of Reporter. Takes the path of the compiled design template (.jrxml) and the wanted 
	 * export path of the report as parameters. Adds a time stamp to the report name, to identify the different reports.
	 * @param designPath
	 * @param exportPath
	 * @throws FileNotFoundException
	 */
	public Reporter(String designPath, String exportPath) throws FileNotFoundException {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		reportGenerator = new ReportGenerator(designPath, exportPath + timestamp);
	}
	/**
	 * A getter for the data field, returns an object of type ReportData.
	 * @return ReportData
	 */
	public ReportData getData() {
		return data;
	}
	
	/**
	 * Setter for the data field.
	 * @param data
	 */
	public void setData(ReportData data) {
		this.data = data;
	}
	
	/**
	 * The important method of this class. Takes a ReportData object as input. Finds all the emergency calls contained
	 * in the ReportData object and generates the report. Returns the path to the exported report.
	 * @param data
	 * @return
	 * @throws JRException
	 */
	public Reporter(String designPath, String exportPath) throws FileNotFoundException {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		reportGenerator = new ReportGenerator(designPath, exportPath + timestamp);
	}
	
	public String generateReport(ReportData data) throws JRException {
		ArrayList<EmergencyCall> emergencies = data.getEmergencies();
		String exportPath = reportGenerator.generateReport(emergencies);
		return exportPath;
	}

}
