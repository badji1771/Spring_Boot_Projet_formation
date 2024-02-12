package org.formation.util;

import org.formation.dto.ProductDto;
import org.formation.model.Product;
import org.springframework.beans.BeanUtils;

public class EntityDtoUtil {

	public static ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(product, dto);
		return dto;
	}
	
	public static  Product toEntity(ProductDto dto) {
		Product product = new Product();
		BeanUtils.copyProperties(dto, product);
		return product;
	}
}
