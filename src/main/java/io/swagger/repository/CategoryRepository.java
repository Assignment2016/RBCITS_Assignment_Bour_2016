package io.swagger.repository;
/**
 * @author antoine
 * Repository
 */

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.CategoryDb;

public interface CategoryRepository  extends JpaRepository<CategoryDb, Long>{ 

}
