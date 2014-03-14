package reporter;

import java.sql.Date;
import java.util.Vector;

public class BeanFactory {
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector createBeanCollection() {
		Vector vector = new Vector();
		vector.add(new EmergencyCall("Henrik", "12345678", "LWN", "ambulance",new Date(System.currentTimeMillis()), Cause.HAZE, true, Location.NORTHWEST));
		return vector;
		}
}
