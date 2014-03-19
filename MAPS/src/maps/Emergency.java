package maps;
/**
 * Contains information about an emergency. Interacts with the CPU_Subsystem to fetch data from the server.
 * @author Prerna Chikersal
 * @see EmergenciesController
 */
public class Emergency {
	/**
	 * The {@link String} instance representing type of crisis.
	 */
	private String crisis;
	
	/**
	 * The {@link String} instance representing time of crisis.
	 */
	private String time;
	
	/**
	 * The {@link String} instance representing name of caller (civilian in crisis).
	 */
	private String callerName;
	
	/**
	 * The {@link String} instance representing phone number of caller (civilian in crisis).
	 */
	private String phone;
	
	/**
	 * The {@link String} instance representing address of caller (civilian in crisis).
	 */
	private String address;
	
	/**
	 * The {@link String} instance representing pin code of caller (civilian in crisis).
	 */
	private String pincode;
	
	/**
	 * The {@link String} instance representing description of the crisis.
	 */
	private String desc;
	
	/**
	 * The {@link String} instance representing status of crisis.
	 */
	private String status;
	
	/**
	 * The {@link String} instance representing name of operator at the call centre.
	 */
	private String operator;
	
	/**
	 * Constructor used to initialize an instance of of {@link Emergency}.
	 */
	public Emergency(String c, String t, String n, String p, String a, String pc, String d, String s, String o){
		crisis=c; time=t; callerName=n; phone=p; address=a; pincode=pc; desc=d; status=s; operator=o;
	}
	
	/**
	 * Gets the {@link String} instance representing type of crisis.
	 * @return The {@link String} instance representing type of crisis.
	 */
	public String getCrisis(){ return crisis;}
	
	/**
	 * Gets the {@link String} instance representing time of crisis.
	 * @return The {@link String} instance representing time of crisis.
	 */
	public String getTime(){ return time;}
	
	/**
	 * Gets the {@link String} instance representing name of caller (civilian in crisis).
	 * @return The {@link String} instance representing name of caller (civilian in crisis).
	 */
	public String getCallerName(){ return callerName;}
	
	/**
	 * Gets the {@link String} instance representing phone number of caller (civilian in crisis).
	 * @return The {@link String} instance representing phone number of caller (civilian in crisis).
	 */
	public String getPhone(){ return phone;}
	
	/**
	 * Gets the {@link String} instance representing address of caller (civilian in crisis).
	 * @return The {@link String} instance representing address of caller (civilian in crisis).
	 */
	public String getAddress(){ return address;}
	
	/**
	 * Gets the {@link String} instance representing pin code of caller (civilian in crisis).
	 * @return The {@link String} instance representing pin code of caller (civilian in crisis).
	 */
	public String getPin(){ return pincode;}
	
	/**
	 * Gets the {@link String} instance representing description of crisis.
	 * @return The {@link String} instance representing description of crisis.
	 */
	public String getDesc(){ return desc;}
	
	/**
	 * Gets the {@link String} instance representing status of crisis.
	 * @return The {@link String} instance representing status of crisis.
	 */
	public String getStatus(){return status;}
	
	/**
	 * Gets the {@link String} instance representing name of operator at the call centre.
	 * @return The {@link String} instance representing name of operator at the call centre.
	 */
	public String getOperator(){return operator;}
	
	/**
	 * Sets the {@link String} instance representing type of crisis.
	 * @param s The {@link String} instance representing type of crisis.
	 */
	public void setCrisis(String s){crisis=s;}
	
	/**
	 * Sets the {@link String} instance representing time of crisis.
	 * @param s The {@link String} instance representing time of crisis.
	 */
	public void setTime(String s){time=s;}
	
	/**
	 * Sets the {@link String} instance representing name of caller (civilian in crisis).
	 * @param s The {@link String} instance representing name of caller (civilian in crisis).
	 */
	public void setCallerName(String s){callerName=s;}
	
	/**
	 * Sets the {@link String} instance representing phone number of caller (civilian in crisis).
	 * @param s The {@link String} instance representing phone number of caller (civilian in crisis).
	 */
	public void setPhone(String s){phone=s;}
	
	/**
	 * Sets the {@link String} instance representing address of caller (civilian in crisis).
	 * @param s The {@link String} instance representing address of caller (civilian in crisis).
	 */
	public void setAddress(String s){address=s;}
	
	/**
	 * Sets the {@link String} instance representing pin code of caller (civilian in crisis).
	 * @param s The {@link String} instance representing pin code of caller (civilian in crisis).
	 */
	public void setPin(String s){pincode=s;}
	
	/**
	 * Sets the {@link String} instance representing description of crisis.
	 * @param s The {@link String} instance representing description of crisis.
	 */
	public void setDesc(String s){desc=s;}
	
	/**
	 * Sets the {@link String} instance representing status of crisis.
	 * @param s The {@link String} instance representing status of crisis.
	 */
	public void setStatus(String s){status=s;}
	
	/**
	 * Sets the {@link String} instance representing name of operator at the call centre.
	 * @param s The {@link String} instance representing name of operator at the call centre.
	 */
	public void setOperator(String s){operator=s;}
}
