package reporter;

import java.sql.Date;

/**
 * A data class used for grouping the information from a reported emergency.Contains a lot of fields,
 *  their associated getters and setters and constructors. Implements the comparable interface for EmergencyCalls. 
 * @author Henrik
 *
 */
public class EmergencyCall implements Comparable<EmergencyCall> {
	
	private String name, phoneNumber, detailedLocation;
	private Date reportingTime;
	private Cause cause;
	private int numberOfDengues, psi;

	public int getPsi() {
		return psi;
	}
	public void setPsi(int psi) {
		this.psi = psi;
	}
	public int getNumberOfDengues() {
		return numberOfDengues;
	}
	public void setNumberOfDengues(int numberOfDengues) {
		this.numberOfDengues = numberOfDengues;
	}
	public String getDetailedLocation() {
		return detailedLocation;
	}
	public void setDetailedLocation(String detailedLocation) {
		this.detailedLocation = detailedLocation;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getReportingTime() {
		return reportingTime;
	}
	public void setReportingTime(Date reportingTime) {
		this.reportingTime = reportingTime;
	}
	public Cause getCause() {
		return cause;
	}
	public void setCause(Cause cause) {
		this.cause = cause;
	}
	
	/**
	 * The commonly used constructor. Initializes all the data fields.
	 * @param name
	 * @param phoneNumber
	 * @param detailedLocation
	 * @param typeOfAssistance
	 * @param reportingTime
	 * @param cause
	 * @param highPriority
	 * @param location
	 */
	public EmergencyCall(String name, String phoneNumber, String detailedLocation,
			Date reportingTime, Cause cause) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.detailedLocation = detailedLocation;
		this.reportingTime = reportingTime;
		this.cause = cause;
	}

	/**
	 * Constructor used for dengue or haze, uses a boolean parameter to tell the difference
	 * @param location
	 * @param detailedLocation
	 * @param numericalValue
	 * @param isDengue
	 */
	public EmergencyCall(String detailedLocation, int numericalValue, Cause cause) {
		if (cause == Cause.DENGUE) {
			this.numberOfDengues = numericalValue;
		}
		else if (cause == Cause.HAZE) {
			this.psi = numericalValue;
		}
		this.detailedLocation = detailedLocation;
		this.cause = cause;
	}
	
	
	
	/**
	 * Empty constructor, mainly used for testing purposes. Kept for flexibility.
	 */
	public EmergencyCall() {
		
	}
	
	/**
	 * Implementation of the comparable interface. Sorts by type of incident.
	 */
	public int compareTo(EmergencyCall other) {
		if (this.psi != 0) {
			return -1;
		}
		else if  (other.psi != 0){
			return 1;
		}
		else if (this.numberOfDengues != 0) {
			return -1;
		}
		else if (other.numberOfDengues != 0) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
