package reporter;

public enum Location {
	SOUTHWEST("South West",1),NORTHWEST("North West",2), CENTRAL("Central",3), NORTHEAST("North East",4),
	SOUTHEAST("South East",5);
	
	private String tostr;
	private int sortingValue;
	
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
