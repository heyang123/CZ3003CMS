package reporter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

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
		reportGenerator = new ReportGenerator(designPath, exportPath);
	}
	
	public String generateReport(ReportData data) throws JRException {
		ArrayList<EmergencyCall> emergencies = data.getEmergencies();
		Collections.sort(emergencies);
		String exportPath = reportGenerator.generateReport(emergencies);
		return exportPath;
	}

}
