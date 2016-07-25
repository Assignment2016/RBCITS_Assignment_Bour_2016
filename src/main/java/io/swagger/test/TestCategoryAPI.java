package io.swagger.test;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

import io.swagger.Swagger2SpringBoot;
import io.swagger.model.CategoryDb;
import io.swagger.repository.CategoryRepository;


@RunWith(SpringJUnit4ClassRunner.class) // 1
@SpringApplicationConfiguration(classes = Swagger2SpringBoot.class) // 2
@WebIntegrationTest 
@IntegrationTest("server.port:8080")
@TestPropertySource(locations="classpath:test.properties")
public class TestCategoryAPI {

	CategoryDb myFirstCateg;
	CategoryDb mySecondCateg;
	CategoryDb myThirdCateg;

	@Autowired
	private CategoryRepository repository;

	@Value("8080")
	int port;

	@Before
	public void setup() {
		myFirstCateg = new CategoryDb();
		myFirstCateg.setId(0L);
		myFirstCateg.setLocalUrl("Cats Url");
		myFirstCateg.setMake("Cats");
		
		mySecondCateg = new CategoryDb();
		mySecondCateg.setId(1L);
		mySecondCateg.setLocalUrl("Dog Url");
		mySecondCateg.setMake("Dog");
		
		myThirdCateg = new CategoryDb();
		myThirdCateg.setId(2L);
		myThirdCateg.setLocalUrl("Wild Url");
		myThirdCateg.setMake("Wild");
		
		repository.deleteAll(); 
		repository.save(Arrays.asList(myFirstCateg, mySecondCateg, myThirdCateg));

		RestAssured.port = port;
	}

	/**
	 * @author antoine
	 * Test the Rest Api For the retrieve of pet categories
	 */
	
	@Test
	public void testGetCategories() {
		RestAssured.when().post("/category/findAllCategories/")
		  .then().statusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		RestAssured.when().get("/category/findAllCategories/")
							.then().statusCode(HttpStatus.OK.value());
		RestAssured.when().delete("/category/findAllCategories")
		.then().statusCode(HttpStatus.METHOD_NOT_ALLOWED.value());

		
	}
	
	@After
	public void tearDown() {
	repository.deleteAll(); 
	}
}
