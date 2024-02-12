package org.formation.service;

import org.formation.model.Post;
import org.formation.repository.PostMongoRepository;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PostServiceImpl implements PostService{

	private PostMongoRepository mongoRepository;
	
	
	public PostServiceImpl(PostMongoRepository mongoRepository) {
		super();
		this.mongoRepository = mongoRepository;
	}

	@Override
	public Flux<Post> getAllPost() {
		
		return mongoRepository.findAll();
	}

	@Override
	public Flux<Post> getPostByName(String name) {
		return null;
	}

	@Override
	public Mono<Post> savePost(Post post) {
		return mongoRepository.save(post);
	}

	@Override
	public Mono<Post> getPostById(String id) {
		return mongoRepository.findById(id);
	}

	@Override
	public Mono<Boolean> existePostById(String id) {
		return mongoRepository.existsById(id);
	}

	@Override
	public void deleteById(String id) {
		mongoRepository.deleteById(id);
	}

}
