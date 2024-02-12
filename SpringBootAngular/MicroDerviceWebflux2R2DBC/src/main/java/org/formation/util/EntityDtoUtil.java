package org.formation.util;

import java.time.LocalDateTime;

import org.formation.dto.TransactionStatus;
import org.formation.dto.TransationResponseDto;
import org.formation.dto.UserDto;
import org.formation.model.User;
import org.formation.model.UserTransaction;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

	public static UserDto toDto(User user) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		return dto;
	}
	
	public static User toEntity(UserDto dto) {
		User user = new User();
		BeanUtils.copyProperties(dto, user);
		return user;
	}
	
	
	public static UserTransaction toEntity(TransationResponseDto requestDto) {
		UserTransaction ut = new UserTransaction();
		ut.setUserId(requestDto.getUserId());
		ut.setAmount(requestDto.getAmount());
		ut.setTransactionDate(LocalDateTime.now());
		return ut;
	}
	
	public static TransationResponseDto toDto(TransationResponseDto requestDo,TransactionStatus status) {
		TransationResponseDto responseDto = new TransationResponseDto();
		responseDto.setAmount(requestDo.getAmount());
		responseDto.setUserId(requestDo.getUserId());
		responseDto.setStatus(status);
		return responseDto;
		
	}
}
