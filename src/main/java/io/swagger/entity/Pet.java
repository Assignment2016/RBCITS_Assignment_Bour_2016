package io.swagger.entity;

/**
 * This class is the entity for the pet
 * 
 * @author antoine
 */
public class Pet {

	private Long id;
	private String make;
	private Long category_id;
	private String localUrl;
	private String description;
	private Long price;

	/**
	 * get the pet id entity
	 * 
	 * @return the Id of the pet entity
	 * @see Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id of the pet entity
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get the name of the pet entity
	 * 
	 * @return the name of the pet entity
	 * @see String
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            the name of the pet entity
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * get the category id of the pet entity
	 * 
	 * @return the category Id of the pet entity
	 * @see Long
	 */
	public Long getCategoryId() {
		return category_id;
	}

	/**
	 * @param category_id
	 *            the id of the pet entity
	 */
	public void setCategoryId(Long category_id) {
		this.category_id = category_id;
	}

	/**
	 * get The url of the image of the pet entity
	 * 
	 * @return The url of the image of the pet entity
	 * @see Long
	 */
	public String getLocalUrl() {
		return localUrl;
	}

	/**
	 * @param localUrl
	 *            The url of the image of the pet entity
	 */
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

	/**
	 * get The description of the pet entity
	 * 
	 * @return The description of the pet entity
	 * @see String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            The description of pet entity
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * get The price of the pet entity
	 * 
	 * @return The price of the pet entity
	 * @see Long
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            The price of the image of the pet entity
	 */
	public void setPrice(Long price) {
		this.price = price;
	}
	
	
	

}
