package reporter;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;

import net.sf.jasperreports.engine.JRException;

public class TestClass {
	
	public static void main(String[] args) throws FileNotFoundException, JRException {
		Reporter reporter = new Reporter("/Users/Henrik/Dropbox/Nanyang sem 2/workspace/CMS/report2.jrxml",
				"/Users/Henrik/Dropbox/Nanyang sem 2/workspace/CMS/report.pdf");
		String exportedReportUrl = reporter.generateReport(createReportData());
		System.out.println(exportedReportUrl);
	}
	
	private static ReportData createReportData() {
		ArrayList<EmergencyCall> mockupCalls = new ArrayList<EmergencyCall>();
		mockupCalls.add(new EmergencyCall("Henrik", "12345678", "LWN", "ambulance",new Date(System.currentTimeMillis()), Cause.HAZE, true, Location.SOUTHEAST));
		mockupCalls.add(new EmergencyCall("Thomas", "2345679", "TCT", "police",new Date(System.currentTimeMillis()), Cause.DENGUEOUTBREAK, true, Location.NORTHEAST));
		ReportData mockupReportData = new ReportData(mockupCalls);
		return mockupReportData;
	}

}
