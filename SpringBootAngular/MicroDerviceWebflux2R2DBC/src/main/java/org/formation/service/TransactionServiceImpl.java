package org.formation.service;

import org.formation.dto.TransactionStatus;
import org.formation.dto.TransationResponseDto;
import org.formation.dto.UserTransactionDto;
import org.formation.model.UserTransaction;
import org.formation.repository.UserRepository;
import org.formation.repository.UserTransactionRepository;
import org.formation.util.EntityDtoUtil;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceImpl implements UserTransactionService{
	
	UserRepository userRepository;
	
	UserTransactionRepository userTransactionRepository;
	

	public TransactionServiceImpl(UserRepository userRepository, UserTransactionRepository userTransactionRepository) {
		this.userRepository = userRepository;
		this.userTransactionRepository = userTransactionRepository;
	}

	@Override
	public Flux<UserTransaction> getByUserId(int userId) {
		return this.userTransactionRepository.findByUserId(userId);
	}

	@Override
	public Mono<TransationResponseDto> createTransaction(final TransationResponseDto requestDto) {
		return this.userRepository.updateUserBalance(requestDto.getUserId(), requestDto.getAmount()).filter(Boolean::booleanValue).map(b->EntityDtoUtil.toEntity(requestDto))
				.flatMap(this.userTransactionRepository::save)
				.map(ut ->EntityDtoUtil.toDto(requestDto,TransactionStatus.APPROVED))
				.defaultIfEmpty(EntityDtoUtil.toDto(requestDto, TransactionStatus.DECLINED));
	}

}
