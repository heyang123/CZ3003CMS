package server;

import model.InfoRecord;
import model.User;

/**
 * @author Zhao Yuan
 * For testing
 */
public class Server {
	
	private static User EXAMPLE_USER = new User();
	
	public static boolean validateUser(User user) {
		EXAMPLE_USER.setUsername("yang");
		EXAMPLE_USER.setPassword("a4380923dd651c195b1631af7c829187");
		if (user.equals(EXAMPLE_USER)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean recordInfo(InfoRecord infoRecord) {
		System.out.print(infoRecord.toString());
		return true;
	}
}
