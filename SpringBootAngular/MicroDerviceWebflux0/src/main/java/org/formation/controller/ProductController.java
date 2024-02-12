package org.formation.controller;

import org.formation.dto.ProductDto;
import org.formation.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
public class ProductController {

	ProductService service;
	
	
	public ProductController(ProductService service) {
		this.service = service;
	}


	@GetMapping("all")
	public Flux<ProductDto> getAll(){
		return service.getAll();
    }
	
	@GetMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> getProductById(@PathVariable String id){
		return this.service.getProductById(id)
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ProductDto> insertProduct(@RequestBody Mono<ProductDto> productDtoMono){
		return this.service.saveProduct(productDtoMono);
	}
	
	@DeleteMapping("{id}")
	public Mono<Void> deleteProduct(@PathVariable String id){
		return this.service.deleteProduct(id);
	}
	@PutMapping("{id}")
	public Mono<ResponseEntity<ProductDto>> updateProduct(@PathVariable String id, @RequestBody Mono<ProductDto> productDtoMono){
		return this.service.updateProduct(id, productDtoMono).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
