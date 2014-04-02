package model;

/**
 * @author Zhao Yuan
 * Call Center report info record
 */
public class InfoRecord {
	@Override
	public String toString() {
		return "InfoRecord [name=" + name + ", phoneNo=" + phoneNo
				+ ", agencyAddress=" + agencyAddress + ", postalCode="
				+ postalCode + ", agencyType=" + agencyType + ", operatorName="
				+ operatorName + "]";
	}
	/**
	 * Reporter name
	 */
	String name = null;
	/**
	 * Reporter mobile number
	 */
	String phoneNo = null;
	/**
	 * Reported agency address
	 */
	String agencyAddress = null;
	/**
	 * Postal code array
	 */
	String postalCode = null;
	/**
	 * Agency type
	 */
	int agencyType;
	/**
	 * Operator Name
	 */
	String operatorName = null;
//	/**
//	 * Reported agency type
//	 */
//	Map<Integer, String> agencyTypes = null;
//	
//	public InfoRecord() {
//		agencyTypes = new HashMap<Integer, String>();
//		// TODO Complex
//		agencyTypes.put(1, "Emergency Ambulance");
//		agencyTypes.put(2, "Rescue and Evacuation");
//		agencyTypes.put(3, "Fire-Flighting");
//		agencyTypes.put(4, "Gas Leak Control");
//	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
	}
	public void setAgencyType(int agencyType) {
		this.agencyType = agencyType;
	}
}
