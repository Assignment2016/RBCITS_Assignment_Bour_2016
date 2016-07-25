/**
 * This class is the model for the categories
 * @author antoine
 * */

package io.swagger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class CategoryDb {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id = null;

	@Column(name = "make")
	private String make = null;

	@Column(name = "local_url")
	private String localUrl = null;

	/**
	 * Get the category id
	 * 
	 * @return The Id of the category
	 * @see Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * get The category id
	 * 
	 * @param id
	 *            Set the category Id
	 * @see Long
	 */

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @see String
	 * @return The male of the pet
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make The make of the pet
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @see String
	 * @return The url of the image concerning the pet
	 */
	public String getLocalUrl() {
		return localUrl;
	}

	/**
	 * @see String
	 * @param localUrl
	 *            The url of the pet
	 */
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

}
