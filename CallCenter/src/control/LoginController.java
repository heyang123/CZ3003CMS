package control;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	 * @throws InterruptedException 
	 */
	public void validateUser(User user, HttpServletResponse response, HttpSession session) throws IOException {
		boolean result = this.serverCommunication.validateUser(user);
		String username = user.getUsername();
		String errMsg = "F";
		String sucMsg = "S";
		if (result) {
			session.setAttribute("loginMsg", sucMsg);
			session.setAttribute("username", username);
			response.sendRedirect("keyInInfo.jsp");
		} else {
			session.setAttribute("loginMsg", errMsg);
			response.sendRedirect("login.jsp");
		}
	}	
}
