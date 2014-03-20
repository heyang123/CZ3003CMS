package reporter;

import java.sql.Date;

public class EmergencyCall implements Comparable<EmergencyCall> {
	
	private String name, phoneNumber, detailedLocation, typeOfAssistance;
	private Date reportingTime;
	private Cause cause;
	private boolean highPriority;
	private Location location;
	
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getTypeOfAssistance() {
		return typeOfAssistance;
	}
	public void setTypeOfAssistance(String typeOfAssistance) {
		this.typeOfAssistance = typeOfAssistance;
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
	public boolean isHighPriority() {
		return highPriority;
	}
	public void setHighPriority(boolean highPriority) {
		this.highPriority = highPriority;
	}
	
	public EmergencyCall(String name, String phoneNumber, String detailedLocation, String typeOfAssistance,
			Date reportingTime, Cause cause, boolean highPriority, Location location) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.detailedLocation = detailedLocation;
		this.typeOfAssistance = typeOfAssistance;
		this.reportingTime = reportingTime;
		this.cause = cause;
		this.highPriority = highPriority;
		this.location = location;
	}
	
	public EmergencyCall() {
		
	}
	
	public int compareTo(EmergencyCall other) {
		if (this.highPriority && ! other.highPriority) {
			return -1;
		}
		else if (!this.highPriority && other.highPriority) {
			return 1;
		}
		else {
		if (this.location.getSortingValue() < other.location.getSortingValue()) {
			return -1;
		}
		else if (this.location.getSortingValue() == other.location.getSortingValue()) {
			if (this.reportingTime.getTime() < other.reportingTime.getTime()) {
				return -1;
			}
			else
				return 1;
		}
		else {
			return 1;
		}
		}
	}
}
