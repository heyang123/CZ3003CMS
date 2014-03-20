package reporter;

import java.util.ArrayList;
import java.util.Collections;

public class ReportData {
	
	private ArrayList<EmergencyCall> emergencies;
	
	
	
	public ArrayList<EmergencyCall> getEmergencies() {
		return emergencies;
	}



	public void setEmergencies(ArrayList<EmergencyCall> emergencies) {
		this.emergencies = emergencies;
	}



	public ReportData(ArrayList<EmergencyCall> emergencies) {
		this.emergencies = emergencies;
		Collections.sort(emergencies);
	}
	
}
