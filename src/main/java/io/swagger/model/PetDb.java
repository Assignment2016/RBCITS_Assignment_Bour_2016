/**
 * @author antoine
 * This class is the model for the pets
 */
package io.swagger.model;
/**
 * This class is the model for the pets
 * @author antoine
 * */

import javax.persistence.*;

@Entity
@Table(name = "pets")
public class PetDb {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id = null;

	@Column(name = "make")
	private String make = null;

	@Column(name = "category_id")
	private Long category_id = null;

	@Column(name = "local_url")
	private String localUrl = null;

	@Column(name = "description")
	private String description = null;

	@Column(name = "price")
	private Long price = null;

	/**
	 * Get the pet id
	 * 
	 * @return The pet Id
	 * @see Long
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            The if of the pet
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the category name
	 * 
	 * @return The name of the category
	 * @see String
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make
	 *            The name of the pet
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * get the category id of the concerned pet
	 * 
	 * @return The Id of the category of the pet
	 * @see Long
	 */
	public Long getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id
	 *            The if of the category linked to the pet
	 */
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	/**
	 * gGet the url of the image linked to the pet
	 * 
	 * @return The local url of the image for this pet
	 * @see String
	 */
	public String getLocalUrl() {
		return localUrl;
	}

	/**
	 * @param localUrl
	 *            The url of the image linked to the pet in the web layer
	 */
	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

	/**
	 * Get the description of the pet
	 * 
	 * @return The description of the pet
	 * @see String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            The description of the pet
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the price of the pet
	 * 
	 * @return The price of the pet
	 * @see Long
	 */
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
