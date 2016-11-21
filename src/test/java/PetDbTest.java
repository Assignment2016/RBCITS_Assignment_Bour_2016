

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import io.swagger.Swagger2SpringBoot;
import io.swagger.entity.Pet;
import io.swagger.model.CategoryDb;
import io.swagger.model.PetDb;
import io.swagger.repository.CategoryRepository;
import io.swagger.repository.PetRepository;
import io.swagger.service.CategoryService;
import io.swagger.service.PetService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Swagger2SpringBoot.class) 
@TestPropertySource(locations="classpath:test.properties")
public class PetDbTest {

	@Autowired
	private PetRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	
	@Autowired
	PetService petService;

	@Autowired
	CategoryService catService;

	PetDb myFirstPet;
	PetDb mySecondPet;
	PetDb myThirdPet;

	//should have a dedicated test schema for that, for the moment it can causes troubles in the database.
	CategoryDb myFirstCat;
	
	
	@Before
	public void setUpDb() {

		myFirstCat = new CategoryDb();
		myFirstCat.setMake("Cat");
		myFirstCat.setId(null);
		
		myFirstPet = new PetDb();
		myFirstPet.setId(0L);
		//myFirstPet.setCategory_id(1L);
		myFirstPet.setDescription("A  first description DB");
		myFirstPet.setLocalUrl("A first Url");
		myFirstPet.setMake("A first make");
		myFirstPet.setPrice(100L);

		mySecondPet = new PetDb();
		mySecondPet.setId(1L);
		//mySecondPet.setCategory_id(1L);
		mySecondPet.setDescription("A second description DB");
		mySecondPet.setLocalUrl("A second Url");
		mySecondPet.setMake("A second make");
		mySecondPet.setPrice(100L);

		myThirdPet = new PetDb();
		myThirdPet.setId(2L);
		//myThirdPet.setCategory_id(1L);
		myThirdPet.setDescription("A third description DB");
		myThirdPet.setLocalUrl("A third Url");
		myThirdPet.setMake("A third make");
		myThirdPet.setPrice(100L);

		catRepository.deleteAll();
		catRepository.save(Arrays.asList(myFirstCat));
			
		myFirstPet.setCategory_id(myFirstCat.getId());
		mySecondPet.setCategory_id(myFirstCat.getId());
		myThirdPet.setCategory_id(myFirstCat.getId());
		
		repository.deleteAll();
		repository.save(Arrays.asList(myFirstPet, mySecondPet, myThirdPet));
		
		
	
	}
	
	@Test
	public void testGetPet() {
		
		assertTrue(petService.findAllPetsByCategory(Integer.parseInt(myFirstCat.getId().toString())).size() == 3);
	}
	
	@Test
	public void testDeletePet() {

		assertTrue(petService.deletePet(myFirstCat.getId()) == 0);
		assertFalse(petService.deletePet(myFirstCat.getId()) == 1);
	}
	
	@Test
	public void testInsertPet() {
		// If I add my manytoOne in the model, then I will push the Category in JSON. Not my idea.
		
		assertTrue(petService.insertPet(castDBPet(myFirstPet)) == 1);
		myFirstPet.setId(null);// automatically generated id.
		assertTrue(petService.insertPet(castDBPet(myFirstPet)) == 1);

		try{
		myFirstPet.setCategory_id(4L);
		petService.insertPet(castDBPet(myFirstPet));
		assertTrue(0==1);
		}catch(org.springframework.dao.DataIntegrityViolationException e){
			assertTrue(true);
		}
	}

	private Pet castDBPet(PetDb pet) {

		Pet thisPet = new Pet();
		thisPet.setId(pet.getId());
		thisPet.setCategoryId(pet.getCategory_id());
		thisPet.setDescription(pet.getDescription());
		thisPet.setLocalUrl(pet.getLocalUrl());
		thisPet.setMake(pet.getMake());
		thisPet.setPrice(pet.getPrice());

		return thisPet;
	}

	@After
	public void tearDown() {
	repository.deleteAll();
	catRepository.deleteAll();
	}
	
}