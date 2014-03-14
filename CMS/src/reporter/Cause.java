package reporter;

public enum Cause {
	HAZE("Haze"), DENGUEOUTBREAK("Dengue Outbreak");
	
	private String tostr;
	
	private Cause(String tostr) {
		this.tostr = tostr;
	}
	
	public String toString() {
		return tostr;
	}
}
