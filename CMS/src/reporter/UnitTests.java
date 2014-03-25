package reporter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTests {
	
	private ArrayList<EmergencyCall> emergencies;
	private ReportData reportData;
	private Cause cause;
	private EmergencyCall emergencyCall;
	private Location location;
	
	@Before
	public void setUp() {
		EmergencyCall testEmergency1 = new EmergencyCall("Henrik", "12345678", "LWN", "ambulance",new Date(System.currentTimeMillis()), Cause.HAZE, true, Location.SOUTHEAST);
		EmergencyCall testEmergency2 = new EmergencyCall("Thomas", "23456789", "TCT", "police",new Date(System.currentTimeMillis()), Cause.DENGUEOUTBREAK, true, Location.NORTHEAST);
		emergencyCall = new EmergencyCall("Thomas", "23456789", "TCT", "police",new Date(System.currentTimeMillis()), Cause.DENGUEOUTBREAK, true, Location.NORTHEAST);
		emergencies = new ArrayList<EmergencyCall>();
		emergencies.add(testEmergency1);
		emergencies.add(testEmergency2);
		//Making a clone of the arraylist because the arraylist is sorted in the constructor of ReportData.
		//Want to be able to test the sorting itself.
		@SuppressWarnings("unchecked")
		ArrayList<EmergencyCall> emergencyClone = (ArrayList<EmergencyCall>)emergencies.clone();
		reportData = new ReportData(emergencyClone);
		cause = Cause.HAZE;
		location = Location.NORTHEAST;
	}
	
	@After
	public void tearDown() {
		emergencies = null;
		reportData = null;
	}
	
	@Test
	public void testEmergencyCall() throws FileNotFoundException{
		assertEquals("Thomas", emergencyCall.getName());
		assertEquals("23456789", emergencyCall.getPhoneNumber());
		assertEquals("TCT", emergencyCall.getDetailedLocation());
		assertEquals("police", emergencyCall.getTypeOfAssistance());
		assertEquals(Date.class, emergencyCall.getReportingTime().getClass());
		assertEquals(Cause.DENGUEOUTBREAK, emergencyCall.getCause());
		assertEquals(Location.NORTHEAST, emergencyCall.getLocation());
	}
	
	@Test
	public void testLocation() {
		assertEquals(Location.NORTHEAST, location);
		assertEquals("North East", location.toString());
		assertEquals(4, location.getSortingValue());
	}
	
	@Test
	public void testCause() {
		assertEquals("Haze", cause.toString());
		assertEquals(Cause.HAZE, cause);
	}
	
	@Test
	public void testReportDataSize() {
		assertEquals(2, reportData.getEmergencies().size());
	}
	
	@Test
	public void testReportDataSorting(){
		//before sorting
		assertEquals("Henrik", emergencies.get(0).getName());
		assertEquals("Thomas", emergencies.get(1).getName());
		//creating a ReportData object, sorts the list in the constructor
		ArrayList<EmergencyCall> emergenciesAfter = reportData.getEmergencies();
		//after sorting
		assertEquals("Henrik", emergenciesAfter.get(1).getName());
		assertEquals("Thomas", emergenciesAfter.get(0).getName());
	}
	
}
