package org.formation.service;

import java.util.List;
import java.util.Optional;

import org.formation.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

	Flux<Post> getAllPost();
	
	Flux<Post> getPostByName(String name);
	
	Mono<Post> savePost(Post coffee);
	
	Mono<Post> getPostById(String id);
	

	Mono<Boolean> existePostById(String id);

	void deleteById(String id);
}
