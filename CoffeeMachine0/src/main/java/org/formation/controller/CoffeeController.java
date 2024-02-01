package org.formation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.formation.model.Coffee;
import org.formation.service.Coffeeservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/coffees")
public class CoffeeController {
	
	public static final Logger LOG = LoggerFactory.getLogger(Coffee.class);

	private Coffeeservice coffeeservice;

	public CoffeeController(Coffeeservice coffeeservice) {
		this.coffeeservice = coffeeservice;
	}

	@GetMapping
	List<Coffee> getCoffees(){
		LOG.trace("====================>trace");
		LOG.debug("====================>debug");
		LOG.info("====================>info");
		LOG.warn("====================>warn");
		LOG.error("====================>error");
		return coffeeservice.getAllCoffees();
	}
	
//	@GetMapping
//	List<Coffee> getCoffees() {
//		return coffeeservice.getAllCoffees();
//	}


	@PostMapping
	Coffee postCoffee(@RequestBody @Valid Coffee coffee) {
		return coffeeservice.saveCoffee(coffee);
	}

	@GetMapping("/{id}")
	ResponseEntity<Coffee> getCoffeeById(@PathVariable Long id) {
		return coffeeservice.getCoffeeById(id)
				.map(c->ResponseEntity.ok().body(c))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable Long id, @RequestBody Coffee coffee) {
		return (coffeeservice.existeCoffeeById(id))
				? new ResponseEntity<>(coffeeservice.saveCoffee(coffee), HttpStatus.OK)
				: new ResponseEntity<>(coffeeservice.saveCoffee(coffee), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable Long id) {
		 coffeeservice.deleteById(id);
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error ->
		{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
