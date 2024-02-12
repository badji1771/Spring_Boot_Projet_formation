package org.formation.dto;

public class ProductDto {

	private String id;
	private String description;
	private String price;
	
	
	public ProductDto(String description, String price) {
		super();
		this.description = description;
		this.price = price;
	}
	public ProductDto() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDto [id=" + id + ", description=" + description + ", price=" + price + "]";
	}
	
	
}
