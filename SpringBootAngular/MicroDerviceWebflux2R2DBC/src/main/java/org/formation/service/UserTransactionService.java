package org.formation.service;

import org.formation.dto.TransationResponseDto;
import org.formation.dto.UserTransactionDto;
import org.formation.model.UserTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserTransactionService {

	

	Flux<UserTransaction> getByUserId(int userId);

	Mono<TransationResponseDto> createTransaction(TransationResponseDto requestDto);
	
	
}
