package org.formation.service;

import java.util.List;
import java.util.Optional;

import org.formation.model.Coffee;

public interface Coffeeservice {

	List<Coffee> getAllCoffees();
	List<Coffee> getCoffeesByName(String name);
	Coffee saveCoffee(Coffee coffee);
	Optional<Coffee> getCoffeeById(Long id);
	boolean existeCoffeeById(Long id);
	
	void deleteById(Long id);
}
