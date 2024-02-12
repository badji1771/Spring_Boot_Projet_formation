package org.formation.service;

import org.formation.dto.ProductDto;
import org.formation.repository.ProductRepository;
import org.formation.util.EntityDtoUtil;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService{

	ProductRepository productRepository;
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Flux<ProductDto> getAll() {
		return this.productRepository.findAll().map(EntityDtoUtil::toDto);
	}

	@Override
	public Flux<ProductDto> getProductByPriceRange(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<ProductDto> getProductById(String id) {
		return this.productRepository.findById(id).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono) {
		return productDtoMono.map(EntityDtoUtil::toEntity).flatMap(this.productRepository::insert).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
		return this.productRepository.findById(id)
				.flatMap(p->productDtoMono.map(EntityDtoUtil::toEntity).doOnNext(e->e.setId(id)))
				.flatMap(this.productRepository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<Void> deleteProduct(String id) {
		return this.productRepository.deleteById(id);
	}

}
