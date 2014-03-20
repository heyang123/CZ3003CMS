package servlet;
import java.io.* ;

import javax.servlet.http.* ;
import javax.servlet.* ;

import model.User;
import control.LoginController;

/**
 * @author Zhao Yuan
 * Use to get user input
 */
public class LoginServlet extends HttpServlet implements Servlet {
	
	/**
	 * Login controller
	 */
	private LoginController loginController = new LoginController();
	/**
	 * User
	 */
	private User user = new User();
	
	/**
	 * Constructor
	 */
	public LoginServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// System.out.print(111);
		// Get user name by id
		String username = request.getParameter("username");
		// Get password by id
		String password = request.getParameter("password");
		// Set user name
		this.user.setUsername(username);
		// Set password
		this.user.setPassword(password);
		// Set user and response to loginController for validation
		this.loginController.validateUser(user, response);

	}
	
	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;
}
