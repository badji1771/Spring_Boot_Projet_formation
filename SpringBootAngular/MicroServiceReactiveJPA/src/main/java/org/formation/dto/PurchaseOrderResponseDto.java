package org.formation.dto;

public class PurchaseOrderResponseDto {

	private Integer orderId;
	
	private Integer userId;
	
	private String productId;
	
	private Integer amount;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PurchaseOrderResponseDto [orderId=" + orderId + ", userId=" + userId + ", productId=" + productId
				+ ", amount=" + amount + "]";
	}
	
	
}
