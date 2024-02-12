package org.formation.util;

import org.formation.dto.OrderStatus;
import org.formation.dto.PurchaseOrderResponseDto;
import org.formation.dto.RequestContext;
import org.formation.dto.TransactionRequestDto;
import org.formation.dto.TransactionResponseDto;
import org.formation.dto.TransactionStatus;
import org.formation.model.PurchaseOrder;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

	public static PurchaseOrderResponseDto getPurchaseOrderResponseDto(PurchaseOrder purchaseOrder) {
		PurchaseOrderResponseDto dto= new PurchaseOrderResponseDto();
		BeanUtils.copyProperties(purchaseOrder, dto);
		dto.setOrderId(purchaseOrder.getId());
		return dto;
	}
	
	public static void setTransactionRequestDto(RequestContext requestContext) {
		TransactionRequestDto dto = new TransactionRequestDto();
		dto.setUserId(requestContext.getPurchaseOrderRequestDto().getUserId());
		dto.setAmount(requestContext.getProductDto().getPrice());
		requestContext.setTransactionRequestDto(dto);
		
	}
	
	public static PurchaseOrder getPurchaseOrder(RequestContext requestContext) {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setUserId(requestContext.getPurchaseOrderRequestDto().getUserId());
		purchaseOrder.setProductId(requestContext.getPurchaseOrderRequestDto().getProductId());
		purchaseOrder.setAmount(requestContext.getProductDto().getPrice());
		TransactionStatus status = requestContext.getTransactionResponseDto().getStatus();
		OrderStatus orderStatus = TransactionStatus.APPROVED.equals(status)?OrderStatus.COMPLET:OrderStatus.FAILED;
		purchaseOrder.setStatus(orderStatus);
		return purchaseOrder;
	}
}
