package reporter;

/**
 * Location enum. Contains the different areas of Singapore. Two fields, one string field, tostr, containing the name to
 * be printed in the report, and one int value used to sort EmergencyCall by location. 
 * @author Henrik
 *
 */
public enum Location {
	SOUTHWEST("South West",1),NORTHWEST("North West",2), CENTRAL("Central",3), NORTHEAST("North East",4),
	SOUTHEAST("South East",5);
	
	private String tostr;
	private int sortingValue;
	
	/**
	 * The only constructor, takes the name to be printed in the report and the internal sorting value as parameters.
	 * @param tostr
	 * @param sortingValue
	 */
	private Location(String tostr, int sortingValue) {
		this.tostr = tostr;
		this.sortingValue = sortingValue;
	}
	
	public String toString() {
		return tostr;
	}
	
	public int getSortingValue() {
		return sortingValue;
	}

}
