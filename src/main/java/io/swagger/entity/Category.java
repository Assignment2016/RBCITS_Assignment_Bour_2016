package io.swagger.entity;

/**
 * This class is the entity for the categories
 * 
 * @author antoine
 */
public class Category {

	private Long id;
	private String make;
	private String localUrl;

	/**
	 * Get the category id
	 * 
	 * @return The Id of the category entity
	 * @see Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id of the category entity
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the name of the category entity
	 * 
	 * @return The name of the category entity
	 * @see String
	 */
	public String getMake() {
		return make;
	}

	/**
	 * 
	 * @param make
	 *            The name of the category entity
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * get the category id
	 * 
	 * @return The Url of the category entity
	 */
	public String getLocalUrl() {
		return localUrl;
	}

	/**
	 * @param localUrl
	 *            The url of the category entity
	 */
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

}
