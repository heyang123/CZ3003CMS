package reporter;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;

import net.sf.jasperreports.engine.JRException;

public class TestClass {
	
	public static void main(String[] args) throws FileNotFoundException, JRException {
		Reporter reporter = new Reporter("/Users/Henrik/Dropbox/Nanyang sem 2/workspace/CMS/report2.jrxml",
				"/Users/Henrik/Dropbox/Nanyang sem 2/workspace/CMS/report");
		String exportedReportUrl = reporter.generateReport(createReportData());
		System.out.println(exportedReportUrl);
	}
	
	private static ReportData createReportData() {
		ArrayList<EmergencyCall> mockupCalls = new ArrayList<EmergencyCall>();
		mockupCalls.add(new EmergencyCall("Henrik", "12345678", "LWN", "ambulance",new Date(System.currentTimeMillis()), Cause.EMERGENCYCALL, Location.SOUTHEAST));
		mockupCalls.add(new EmergencyCall("Thomas", "2345679", "TCT", "police",new Date(System.currentTimeMillis()), Cause.EMERGENCYCALL,  Location.NORTHEAST));
		mockupCalls.add(new EmergencyCall(Location.CENTRAL, "Clarke Quay", 100, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.CENTRAL, "Clarke Quay", 100, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.CENTRAL, "Clarke Quay", 100, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.CENTRAL, "Clarke Quay", 100, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.CENTRAL, "Clarke Quay", 100, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.NORTHEAST, "Chinese Garden", 150, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.NORTHEAST, "Chinese Garden", 150, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.NORTHEAST, "Chinese Garden", 150, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.NORTHEAST, "Chinese Garden", 150, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.NORTHEAST, "Chinese Garden", 150, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.NORTHEAST, "Chinese Garden", 150, Cause.DENGUE));
		mockupCalls.add(new EmergencyCall(Location.SOUTHWEST, "Lakeside", 39, Cause.HAZE));
		mockupCalls.add(new EmergencyCall(Location.SOUTHEAST, "Jurong West", 49, Cause.HAZE));
		ReportData mockupReportData = new ReportData(mockupCalls);
		return mockupReportData;
	}
}
