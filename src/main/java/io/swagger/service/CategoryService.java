package io.swagger.service;

/**
 * The DAO layer for Categories
 * @author antoine
 */
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import io.swagger.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * get all categories of pets available in the database
	 * 
	 * @return a list of categories
	 */
	public List<Category> getAllCategory() {
		return jdbcTemplate.query("SELECT * FROM category", new RowMapper<Category>() {

			public Category mapRow(ResultSet rs, int arg1) throws SQLException {
				Category c = new Category();
				c.setId(rs.getLong("id"));
				c.setLocalUrl(rs.getString("local_url"));
				c.setMake(rs.getString("make"));

				return c;
			}

		});

	}
}
