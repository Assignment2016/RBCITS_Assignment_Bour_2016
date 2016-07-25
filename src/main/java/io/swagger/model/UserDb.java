/**
 * @author antoine
 * This class is the model for the users
 */
package io.swagger.model;
/**
 * This class is the model for the user
 * @author antoine
 * */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@javax.persistence.SequenceGenerator(name = "SEQ_STORE", sequenceName = "pet_user_sequence")

@Table(name = "pet_user")
public class UserDb {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
	@Column(name = "user_id")
	private Long userId = null;

	@Column(name = "username")
	private String userName = null;

	@Column(name = "password")
	private String password = null;

	@Column(name = "role")
	private String userRole = null; // A=Admin , U = User,

	/**
	 * Get the userId
	 * 
	 * @return The Id of the user
	 * @see Long
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            The id of the user
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * get the user name
	 * 
	 * @return The user name
	 * @see String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 
	 * @param userName
	 *            The user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get the password of the user
	 * 
	 * @return The non encrypted password
	 * @see String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get the role of the user
	 * 
	 * @return The user role, A for Admin U for simple user
	 * @see Long
	 */

	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            The role of the user U for User or A for Administrator
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
