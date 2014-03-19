package model;

/**
 * @author Zhao Yuan
 * User for user login, including user name and password
 */
public class User {
	/**
	 * User name
	 */
	private String username = null;
	/**
	 * User password
	 */
	private String password = null;

	/**
	 * @param username
	 * Set user name
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * @param password
	 * Set password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}	
}
