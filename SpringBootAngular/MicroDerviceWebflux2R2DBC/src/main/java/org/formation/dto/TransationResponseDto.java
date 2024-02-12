package org.formation.dto;

public class TransationResponseDto {

	private Integer userId;
	private Integer amount;
	private TransactionStatus status;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public TransactionStatus getStatus() {
		return status;
	}
	public void setStatus(TransactionStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransationResponseDto [userId=" + userId + ", amount=" + amount + ", status=" + status + "]";
	}
	
	
}
