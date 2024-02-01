package org.formation.service;

import java.util.List;
import java.util.Optional;

import org.formation.model.Coffee;
import org.formation.repository.CoffeeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service("service")
public class ServiceImpl implements Coffeeservice{

	private CoffeeRepository coffeeRepository;

	

	public ServiceImpl(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}

	@Override
	public List<Coffee> getAllCoffees() {
		return coffeeRepository.findAll();
	}

	@Override
	public List<Coffee> getCoffeesByName(String name) {
		return coffeeRepository.findByNameContainingIgnoreCase(name, 
				Sort.by(Sort.Order
						.asc("name").ignoreCase()));
				
	}

	@Override
	public Coffee saveCoffee(Coffee coffee) {
		return coffeeRepository.save(coffee);
	}

	@Override
	public Optional<Coffee> getCoffeeById(Long id) {
		return coffeeRepository.findById(id);
	}

	@Override
	public boolean existeCoffeeById(Long id) {
		return coffeeRepository.existsById(id);
	}

	@Override
	public void deleteById(Long id) {

		coffeeRepository.deleteById(id);
	}
	
}
