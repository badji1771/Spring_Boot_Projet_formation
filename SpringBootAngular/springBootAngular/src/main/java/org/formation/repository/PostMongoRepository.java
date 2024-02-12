package org.formation.repository;

import org.formation.model.Post;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PostMongoRepository extends ReactiveMongoRepository<Post, String>{

	
}
