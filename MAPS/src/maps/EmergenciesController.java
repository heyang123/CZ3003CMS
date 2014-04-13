package maps;
import java.util.*;
import maps.test.EmergencyFactoryStub;

import maps.Emergency;
/**
 * Controls the ArrayList of all {@link addresses}, {@link correspondingContents} and {@link correspondingCrisis} by loading data into them, 
 * returning details like the total number of emergencies, address and type of crisis at a particular index of the ArrayList.
 * This class also creates the text to be displayed as a "tool-tip" on the map when a marker is clicked, for an instance of the {@link MapsController} class.
 * @author Prerna Chikersal
 * @see Emergency, MapsController
 */
public class EmergenciesController {
	/**
	 * An ArrayList of {@link String} instances which represents all the addresses of emergencies to be displayed on the map
	 */
	private List<String>addresses = new ArrayList<String>();
	/**
	 * An ArrayList of {@link String} instances which represents all the content of emergencies to be displayed on the map
	 */
	private List<String>correspondingContents = new ArrayList<String>();
	/**
	 * An ArrayList of {@link String} instances which represents all the types of crisis of emergencies to be displayed on the map
	 */
	private List<String>correspondingCrisis = new ArrayList<String>();
	
	/**
	 * Loads data into {@link addresses}, {@link correspondingContents} and {@link correspondingCrisis} by looping through all instances of {@link Emergency}, which each fetch data from the server or stub.
	 */
	public void fetchAllEmergencies(){
		EmergencyFactoryStub stub = new EmergencyFactoryStub();
		Emergency[] emergencyList = stub.getEmergencies();
		for(int ne=0; ne<emergencyList.length; ne++){
			createContent(emergencyList[ne]);
		}
	}
	
	/**
	 * Gets the integer length of {@link addresses}, which also represents the total number of emergencies.
	 * @return integer length of {@link addresses}.
	 */
	public int getNumEmergencies(){
		return addresses.size();
	}
	
	/**
	 * Gets the {@link String} instance representing address of the caller in the crisis stored at a particular index of {@link Emergencies}.
	 * @return The {@link String} instance representing address of the caller in the crisis 
	 * @param i a particular index {@param i} of {@link addresses}
	 */
	public String getAddressAti(int i){
		return addresses.get(i);
	}
	
	/**
	 * Gets the {@link String} instance representing type of crisis stored at a particular index of {@link correspondingCrisis}.
	 * @return The {@link String} instance representing type of crisis 
	 * @param i a particular index {@param i} of {@link correspondingCrisis}
	 */
	public String getCrisisAti(int i){
		return correspondingCrisis.get(i);
	}
	
	/**
	 * Creates and stores the {@link String} instance representing the content to be displayed when the user clicks the map marker corresponding to the instance of {@link Emergency} at index {@param i} of {@link addresses}.
	 * @param i a particular index {@param i} of {@link addresses} for whose marker we return the content to be displayed
	 */
	private void createContent(Emergency e){
		addresses.add(e.getAddress());
        correspondingCrisis.add(e.getCrisis());
		StringBuilder builder = new StringBuilder();
		builder.append("<strong>");
        builder.append(e.getCrisis());
        builder.append("&nbsp;Crisis at ");
        builder.append(e.getTime());
        builder.append("</strong>");
        builder.append("<br><strong>Caller:</strong>&nbsp;");
        builder.append(e.getCallerName());
        builder.append("&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;<strong>Phone:</strong>&nbsp;");
        builder.append(e.getPhone());
        builder.append("<br><strong>Address:</strong>&nbsp;");
        builder.append(e.getAddress());
        builder.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        builder.append(e.getPin());
        builder.append("<br><strong>Status:</strong>&nbsp;");
        builder.append(e.getStatus());
        builder.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>Operator:</strong>&nbsp;");
        builder.append(e.getOperator());
        builder.append("<br><strong>Note:</strong>&nbsp;");
        builder.append(e.getDesc());
		correspondingContents.add(builder.toString());
	}
	/**
	 * Gets the {@link String} instance representing the content to be displayed when the user clicks the map marker corresponding to the instance of {@link Emergency} at index {@param i} of {@link addresses}.
	 * @return The {@link String} instance representing the content to be displayed when the user clicks the map marker 
	 * @param i a particular index {@param i} of {@link addresses} for whose marker we return the content to be displayed
	 */
	public String getContentAti(int i){
		return correspondingContents.get(i);
	}
}