package org.formation.controller;

import org.formation.client.OrderFulfillmentService;
import org.formation.dto.PurchaseOrderRequestDto;
import org.formation.dto.PurchaseOrderResponseDto;
import org.formation.service.OrderQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("order")
public class PurchaseOrderController {

	private OrderFulfillmentService orderFulfillmentService;

	private OrderQueryService queryService;

	public PurchaseOrderController(OrderFulfillmentService orderFulfillmentService, OrderQueryService queryService) {
		this.orderFulfillmentService = orderFulfillmentService;
		this.queryService = queryService;
	}

	@PostMapping
	Mono<PurchaseOrderResponseDto> order(@RequestBody Mono<PurchaseOrderRequestDto> requestDtoMono) {
		return this.orderFulfillmentService.processOrder(requestDtoMono)
				.onErrorResume(throwable -> {
	                // Gérez l'exception ici
	                return Mono.just(new PurchaseOrderResponseDto());
	            });
	}

	@GetMapping("user/{userId}")
	Flux<PurchaseOrderResponseDto> getOrdersByUserId(@PathVariable int userId) {
		return this.queryService.getProductsByUserId(userId);
	}
}
