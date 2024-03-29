package org.formation.controller;

import org.formation.dto.UserDto;
import org.formation.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;

	

	
	
	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public Flux<UserDto> all(){
		return this.service.getAll();
	}
	
	@PostMapping
	public Mono<UserDto> createUser(@RequestBody Mono<UserDto> userDtoMono){
		return this.service.createUser(userDtoMono);
	}
	
	@DeleteMapping
	public Mono<Void> deleteUser(@PathVariable int id){
		return this.service.deleteUser(id);
	}
	
	@GetMapping("{id}")
	public Mono<ResponseEntity<UserDto>> getUserById(@PathVariable int id){
		return this.service.getUserById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PutMapping("{id}")
	public Mono<ResponseEntity<UserDto>> updateUser(@PathVariable int id, @RequestBody Mono<UserDto> userDtoMono){
		return this.service.updateUser(id, userDtoMono).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
