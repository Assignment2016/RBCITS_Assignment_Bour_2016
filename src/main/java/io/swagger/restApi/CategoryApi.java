/**
 * Service layer for categories
 * @author antoine
 */

package io.swagger.restApi;

import org.apache.log4j.Logger;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.entity.Category;
import io.swagger.service.CategoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value = "/category", produces = { "application/json" })
public class CategoryApi {

	@Autowired
	CategoryService catService;

	final static Logger logger = Logger.getLogger(CategoryApi.class);

	/**
	 * @return A List of category Entity
	 * @throws Exception Should not happen
	 */
	@RequestMapping(value = "/findAllCategories" ,method = RequestMethod.GET)
	public List<Category> findCategories() throws Exception {

		logger.info("retrieve all categories");
		List<Category> cat = catService.getAllCategory();
		logger.info("all categories retrieved" + cat.size());
		return cat;
	}
}