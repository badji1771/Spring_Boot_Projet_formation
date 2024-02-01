package org.formation.repository;

import java.util.List;

import org.formation.model.Coffee;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@Component
public class DbInit {

	private CoffeeRepository coffeeRepository;

	public DbInit(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}
	@PostConstruct
	public void initCoffees() {
		coffeeRepository.saveAll(List.of(
				new Coffee("Granador"),
				new Coffee("Albenio"),
				new Coffee("Tres puntas")
				));
	}
}
