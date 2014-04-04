package reporter;

import java.sql.Date;
import java.util.Vector;

public class BeanFactory {
	
	/**
	 * Class that was only used for the design of the design template. Not used during
	 * generation of the report.
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector createBeanCollection() {
		Vector vector = new Vector();
		vector.add(new EmergencyCall("Henrik", "12345678", "LWN", "ambulance",new Date(System.currentTimeMillis()), Cause.HAZE, Location.NORTHWEST));
		return vector;
		}
}
