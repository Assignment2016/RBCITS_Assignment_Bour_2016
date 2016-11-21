/**
 * Service layer for Pets
 * @author antoine
 */

package io.swagger.restApi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.entity.Pet;
import io.swagger.service.PetService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/pet", produces = { "application/json" })
public class PetApi {

	final static Logger logger = Logger.getLogger(PetApi.class);
	// http://www.baeldung.com/spring-requestmapping
	// http://www.byteslounge.com/tutorials/spring-with-hibernate-persistence-and-transactions-example

	@Autowired
	PetService petService;

	/**
	 * 
	 * @param categoryId
	 *            The category id of the pets to retrieve
	 * @return A list of pets
	 * @throws Exception
	 *             Should not happen
	 */
	//@ResponseBody

	@RequestMapping(value = "/findPetCategoryById/{categoryId}", method = RequestMethod.GET)
	public List<Pet> findPets(@PathVariable("categoryId") int categoryId) throws Exception {

		logger.info("find pets" + categoryId);
		
		List<Pet> pets = petService.findAllPetsByCategory(categoryId);

		/*for (Iterator iterator = pets.iterator(); iterator.hasNext();) {
			Pet pet = (Pet) iterator.next();
			System.out.println(pet.getId() + "-" + pet.getMake() + "-" + pet.getLocalUrl());
		}*/

		logger.info("pet list size: " + pets.size());
		return pets;
	}

	/**
	 * 
	 * @param petId
	 *            the pet Id to be deleted
	 * @return True or false depending on the succes or not of the operation
	 * @throws Exception
	 *             Should not happen
	 */
	@RequestMapping(value = "/deletePetById/{petId}", method = RequestMethod.DELETE)
	public boolean deletePet(@PathVariable("petId") Long petId) throws Exception {
		logger.info("delete Pet");
		try {
			petService.deletePet(petId);
			logger.info("delete successful");
			return true;

		} catch (Exception e) {

			logger.info("delete in error");
			return false;
		}

	}

	/**
	 * http://stackoverflow.com/questions/31667945/multiple-requestmapping-value-with-path-variables
	 * 
	 * @param make
	 *            The name of the pet
	 * @param categoryId
	 *            the category Id linked to the pet
	 * @param url
	 *            The Url of the image associated to the pet
	 * @param description
	 *            the description associated to the pet
	 * @param price
	 *            the price of the pet
	 * @throws Exception
	 *             Should not happen :-)
	 */
	@RequestMapping(value = "/createPet/{make}/{categoryId}/{localUrl}/{description}/{price}", method = RequestMethod.POST)
	public void createPet(@PathVariable("make") String make, @PathVariable("categoryId") long categoryId,
			@PathVariable("localUrl") String url, @PathVariable("description") String description,
			@PathVariable("price") Long price) throws Exception {

		logger.info("create a pet:");
		logger.info("make:" + make);
		logger.info("categoryId:" + categoryId);
		logger.info("url:" + url);
		logger.info("description:" + description);
		logger.info("price:" + price);

		Pet pet = new Pet();
		pet.setCategoryId(categoryId);
		pet.setDescription(description);
		pet.setLocalUrl(url.replaceAll("@", "/"));
		pet.setMake(make);
		pet.setPrice(price);

		petService.insertPet(pet);
		logger.info("pet inserted");

	}

}
