package io.swagger.service;
/**
 * The DAO layer for the Pets
 * @author antoine
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import io.swagger.entity.Pet;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class PetService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Insert a pet
	 * 
	 * @param pet
	 *            The pet to insert
	 * @return 0 if issues, 1 if ok
	 */
	public int insertPet(Pet pet) {

		String sql = "insert into Pets (make,category_id,local_url,description,price) values (?,?,?,?,?)";
		return jdbcTemplate.update(sql, pet.getMake(), pet.getCategoryId(), pet.getLocalUrl(), pet.getDescription(),
				pet.getPrice());
	}

	/**
	 * Delete a pet
	 * 
	 * @param petId
	 *            The id of the pet to delete
	 * @return 0 if issue, 1 if ok
	 */
	public int deletePet(Long petId) {

		String sql = "delete from Pets where id=" + petId;
		int returnVal = jdbcTemplate.update(sql);
		return returnVal;
	}

	/**
	 * Get all pets from the wished category
	 * 
	 * @param categoryId
	 *            The category Id of the pets to retrieve
	 * @return A list of Pets
	 */
	public List<Pet> findAllPetsByCategory(int categoryId) {

		return jdbcTemplate.query("SELECT * FROM Pets where category_Id=" + categoryId, new RowMapper<Pet>() {

			public Pet mapRow(ResultSet rs, int arg1) throws SQLException {
				Pet p = new Pet();
				p.setCategoryId(rs.getLong("category_id"));
				p.setDescription(rs.getString("description"));
				p.setLocalUrl(rs.getString("local_url"));
				p.setId(rs.getLong("id"));
				p.setMake(rs.getString("make"));
				p.setPrice(rs.getLong("price"));
				return p;
			}

		});

	}

	
}
