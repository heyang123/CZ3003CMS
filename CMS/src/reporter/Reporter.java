package reporter;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import net.sf.jasperreports.engine.JRException;

public class Reporter {
	
	private ReportData data;
	private ReportGenerator reportGenerator;
	
	public ReportData getData() {
		return data;
	}
	
	public void setData(ReportData data) {
		this.data = data;
	}
	
	public Reporter(String designPath, String exportPath) throws FileNotFoundException {
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		reportGenerator = new ReportGenerator(designPath, exportPath + timestamp);
	}
	
	public String generateReport(ReportData data) throws JRException {
		ArrayList<EmergencyCall> emergencies = data.getEmergencies();
		Collections.sort(emergencies);
		String exportPath = reportGenerator.generateReport(emergencies);
		return exportPath;
	}

}
