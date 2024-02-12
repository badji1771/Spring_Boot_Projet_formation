package org.formation.controller;

import org.formation.dto.TransationResponseDto;
import org.formation.service.UserTransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {

	private UserTransactionService transactionService;

	public UserTransactionController(UserTransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@PostMapping
	public Mono<TransationResponseDto> createTransaction(@RequestBody Mono<TransationResponseDto> requestDtoMono){
		return requestDtoMono.flatMap(this.transactionService::createTransaction);
	}
}
