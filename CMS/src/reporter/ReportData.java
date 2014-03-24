package reporter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Data class. Contains an arraylist of emergencycalls and associated getter, setter and constructor.
 * @author Henrik
 *
 */
public class ReportData {
	
	private ArrayList<EmergencyCall> emergencies;
	
	/**
	 * The only constructor. Takes an arraylist of EmergencyCall as parameter. Sorts the arraylist, so the 
	 * EmergencyCalls appears in the right order in the generated report.
	 * @param emergencies
	 */
	public ReportData(ArrayList<EmergencyCall> emergencies) {
		this.emergencies = emergencies;
		Collections.sort(emergencies);
	}
	
	/**
	 * Getter of the only field of the class, returns an arraylist of EmergencyCall.
	 * @return ArrayList<EmergencyCall>
	 */
	public ArrayList<EmergencyCall> getEmergencies() {
		return emergencies;
	}


	/**
	 * Setter of the only field of the class. Sorts the arraylist and sets the field.
	 * @param emergencies
	 */
	public void setEmergencies(ArrayList<EmergencyCall> emergencies) {
		Collections.sort(emergencies);
		this.emergencies = emergencies;
	}



	
}
