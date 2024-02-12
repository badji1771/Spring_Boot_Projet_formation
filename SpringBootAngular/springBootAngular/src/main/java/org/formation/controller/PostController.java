package org.formation.controller;

import org.formation.model.Post;
import org.formation.service.PostService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/posts")
public class PostController {
	
	private PostService service;

	public PostController(PostService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public Flux<Post> getAll(){
		return service.getAllPost();
    }

	@PostMapping
	public Mono<Post> createOn(@RequestBody @Valid Post post){
		System.out.println("Post "+post);
		return service.savePost(post);
	}
	@GetMapping("/{id}")
	public Mono<Post> getOn(@PathVariable String id){
		return service.getPostById(id);
	}
	
	@DeleteMapping("/{id}")
	void deletePost(@PathVariable String id) {
		System.out.println("Post a supprimer "+id);
		service.deleteById(id);
	}
	
}
