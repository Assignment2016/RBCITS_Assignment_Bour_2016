package io.swagger.repository;
/**
 * @author antoine
 * Repository
 */

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.PetDb;

public interface PetRepository  extends JpaRepository<PetDb, Long>{

}
