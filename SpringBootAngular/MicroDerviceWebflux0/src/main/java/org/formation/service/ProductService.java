package org.formation.service;

import org.formation.dto.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	Flux<ProductDto> getAll();
	
	Flux<ProductDto> getProductByPriceRange(int min, int max);
	
	Mono<ProductDto> getProductById(String id);
	
	Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono);
	
	Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono);
	
	Mono<Void> deleteProduct(String id);
}
