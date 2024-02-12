package org.formation.service;

import org.formation.dto.UserDto;
import org.formation.repository.UserRepository;
import org.formation.util.EntityDtoUtil;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{

	UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public Flux<UserDto> getAll() {
		return this.repository.findAll().map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> getUserById(int userId) {
		return this.repository.findById(userId).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
		return userDtoMono.map(EntityDtoUtil::toEntity).flatMap(this.repository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono) {
		return this.repository.findById(id)
				.flatMap(u->userDtoMono.map(EntityDtoUtil::toEntity).doOnNext(e->e.setId(id)))
				.flatMap(this.repository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<Void> deleteUser(int id) {
		return this.repository.deleteById(id);
	}

}
