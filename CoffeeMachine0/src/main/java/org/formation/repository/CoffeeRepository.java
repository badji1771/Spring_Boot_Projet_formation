package org.formation.repository;

import java.util.List;

import org.formation.model.Coffee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoffeeRepository extends JpaRepository<Coffee, Long>{

	List<Coffee> findByName(String name);
	List<Coffee> findByNameContainingIgnoreCase(String name,Sort sort);
	
}
