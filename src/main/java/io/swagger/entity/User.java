package io.swagger.entity;

public class User {

	private Long userId = null;
	private String userName;
	private String password;
	private String userRole; // A=Admin , U = User,

	/**
	 * Get the User id
	 * 
	 * @return The Id of the user
	 * @see Long
	 */

	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the user ID of the user entity
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * Get the User Name
	 * 
	 * @return The Name of the user
	 * @see String
	 */

	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the user Name of the user entity
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get the Password of the user
	 * 
	 * @return The Id of the user
	 * @see Long
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password of the user entity
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the User role U for user, A for Admin
	 * 
	 * @return The Id of the user
	 * @see Long
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the user Role of the user entity
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
