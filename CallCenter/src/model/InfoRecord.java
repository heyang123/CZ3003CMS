package model;

/**
 * @author Zhao Yuan
 * Call Center report info record
 */
public class InfoRecord {
	/**
	 * Reporter name
	 */
	String name = null;
	/**
	 * Reporter mobile number
	 */
	String mobileNumber = null;
	/**
	 * Reported location
	 */
	String location = null;
	/**
	 * Reported type of assistance request
	 */
	String typeOfAssistanceRequest = null;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setTypeOfAssistanceRequest(String typeOfAssistanceRequest) {
		this.typeOfAssistanceRequest = typeOfAssistanceRequest;
	}
}
