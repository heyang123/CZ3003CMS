package reporter;

/**
 * Enum for different causes. Contains a string field used in the report.
 * @author Henrik
 *
 */
public enum Cause {
	HAZE("Haze"), DENGUE("Dengue Outbreak"), EMERGENCYCALL("Emergency Call");
	
	private String tostr;
	
	private Cause(String tostr) {
		this.tostr = tostr;
	}
	
	public String toString() {
		return tostr;
	}
}
