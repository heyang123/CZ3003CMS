package test;

import model.User;
import server.Server;

public class Main {
	
	public static void main(String[] args) {
		User user= new User();
		user.setUsername("ya2ng");
		user.setPassword("3033");
		System.out.print(Server.validateUser(user));
	}

}
