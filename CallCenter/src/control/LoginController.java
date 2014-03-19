package control;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import model.ServerCommunication;
import model.User;

/**
 * @author Zhao Yuan
 * Controller to control login
 */
public class LoginController {
	
	/**
	 * A ServerCommunication object using for user validation
	 */
	private ServerCommunication serverCommunication = null;
	
	/**
	 * Constructor
	 */
	public LoginController() {
		// Initiate serverCommunication
		this.serverCommunication = new ServerCommunication();
	}
	
	// TODO error handling
	/**
	 * @param user
	 * Validate user
	 * @throws IOException 
	 */
	public void validateUser(User user, HttpServletResponse response) throws IOException {
		boolean result = this.serverCommunication.validateUser(user);
		if (result) {
			response.sendRedirect("keyInInfo.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}	
}
