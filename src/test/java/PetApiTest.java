

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
import io.swagger.model.PetDb;
import io.swagger.repository.CategoryRepository;
import io.swagger.repository.PetRepository;

/**
 * http://javabeat.net/spring-boot-testing/
 * 
 * @author antoine Testing class
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 1
@SpringApplicationConfiguration(classes = Swagger2SpringBoot.class) // 2
@WebIntegrationTest 
@TestPropertySource(locations="classpath:test.properties")
@IntegrationTest("server.port:8080")
public class PetApiTest {

	PetDb myFirstPet;
	PetDb mySecondPet;
	PetDb myThirdPet;
	CategoryDb myCat;
	
	@Autowired
	private PetRepository repository;
	
	@Autowired
	private CategoryRepository catRrepository;

	@Value("8080")
	int port;

	@Before
	public void setup() {

		myCat = new CategoryDb();
		myCat.setMake("First cat");
		
		myFirstPet = new PetDb();
		myFirstPet.setId(0L);
		//myFirstPet.setCategory_id(1L);
		myFirstPet.setDescription("A  first description API");
		myFirstPet.setLocalUrl("A first Url");
		myFirstPet.setMake("A first make");
		myFirstPet.setPrice(100L);

		mySecondPet = new PetDb();
		mySecondPet.setId(1L);
		//mySecondPet.setCategory_id(1L);
		mySecondPet.setDescription("A second description API");
		mySecondPet.setLocalUrl("A second Url");
		mySecondPet.setMake("A second make");
		mySecondPet.setPrice(100L);

		myThirdPet = new PetDb();
		myThirdPet.setId(2L);
		//myThirdPet.setCategory_id(1L);
		myThirdPet.setDescription("A third description API");
		myThirdPet.setLocalUrl("A third Url");
		myThirdPet.setMake("A third make");
		myThirdPet.setPrice(100L);

		
		catRrepository.save(Arrays.asList(myCat));
		
		myFirstPet.setCategory_id(myCat.getId());
		mySecondPet.setCategory_id(myCat.getId());
		myThirdPet.setCategory_id(myCat.getId());
		
		repository.deleteAll(); 
		repository.save(Arrays.asList(myFirstPet, mySecondPet, myThirdPet));
		RestAssured.port = port;

	}

	/**
	 * @author antoine
	 * Test the Rest Api For the delete of pets
	 */
	
	@Test
	public void testDeletePet() {
		
		//https://msdn.microsoft.com/en-us/library/windows/desktop/aa384325(v=vs.85).aspx
		RestAssured.when().delete("/pet/deletePetById/" + mySecondPet.getId()).then().statusCode(HttpStatus.OK.value());
		RestAssured.when().delete("/pet/deletePetById/" ).then().statusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		RestAssured.when().get("/pet/deletePetById/" ).then().statusCode(HttpStatus.NOT_FOUND.value());
	
	}
	
	/**
	 * @author antoine
	 * Test the Rest Api For the insert of pets
	 */
	
	
	@Test
	public void testInsertPet() {
				//https://msdn.microsoft.com/en-us/library/windows/desktop/aa384325(v=vs.85).aspx
		RestAssured.when().delete("/pet/deletePetById/" + mySecondPet.getId()).then().statusCode(HttpStatus.OK.value());
		RestAssured.when().post("pet/createPet/"+mySecondPet.getMake()+"/"+mySecondPet.getCategory_id()+"/"+mySecondPet.getLocalUrl()+"/"+mySecondPet.getDescription()+"/"+mySecondPet.getPrice())
						  .then().statusCode(HttpStatus.OK.value());
		RestAssured.when().get("pet/createPet/"+mySecondPet.getMake()+"/"+mySecondPet.getCategory_id()+"/"+mySecondPet.getLocalUrl()+"/"+mySecondPet.getDescription()+"/"+mySecondPet.getPrice())
		  .then().statusCode(HttpStatus.METHOD_NOT_ALLOWED.value());
		
	}
	
	/**
	 * @author antoine
	 * Test the Rest Api For the retrieve of pets
	 */
	
	@Test
	public void testGetPet() {
		RestAssured.when().post("pet/createPet/"+myThirdPet.getMake()+"/"+myThirdPet.getCategory_id()+"/"+myThirdPet.getLocalUrl()+"/"+myThirdPet.getDescription()+"/"+myThirdPet.getPrice())
		  .then().statusCode(HttpStatus.OK.value());
		RestAssured.when().get("/pet/findPetCategoryById/"+myThirdPet.getCategory_id())
							.then().statusCode(HttpStatus.OK.value());
		/*RestAssured.when().delete("pet/findPetCategoryById/"+myThirdPet.getCategory_id())
		.then().statusCode(HttpStatus.BAD_REQUEST.value());*/
		
		
	}
	
	@After
	public void tearDown() {
	repository.deleteAll(); 
	}
	
	
}
