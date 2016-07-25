package io.swagger.test;

import java.util.Arrays;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import io.swagger.Swagger2SpringBoot;
import io.swagger.model.CategoryDb;
import io.swagger.repository.CategoryRepository;
import io.swagger.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Swagger2SpringBoot.class) // Application being
@TestPropertySource(locations = "classpath:test.properties") // your
public class TestCategoryDb {

	@Autowired
	private CategoryRepository catRepository;

	@Autowired
	CategoryService catService;

	CategoryDb cat1;
	CategoryDb cat2;
	CategoryDb cat3;

	@Before
	public void setUpDb() {

		cat1 = new CategoryDb();
		cat1.setId(0L);
		cat1.setMake("Cats");
		cat1.setLocalUrl("Cat Url");

		cat2 = new CategoryDb();
		cat2.setId(1L);
		cat2.setMake("DOGS");
		cat2.setLocalUrl("DOG Url");

		cat3 = new CategoryDb();
		cat3.setId(2L);
		cat3.setMake("FISH");
		cat3.setLocalUrl("FISH Url");

		catRepository.save(Arrays.asList(cat1, cat2, cat3));
	}

	@Test
	public void testGetCategories() {

		assertTrue(catService.getAllCategory().size() == 3);
	}

	@After
	public void tearDown() {
		catRepository.deleteAll();
	}
}
