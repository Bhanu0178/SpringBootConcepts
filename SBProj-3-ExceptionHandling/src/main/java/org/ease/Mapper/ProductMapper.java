package org.ease.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.ease.DTO.ProductDTO;
import org.ease.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductMapper {
	
	private  ModelMapper mapper;
	
	public ProductDTO entityToDto(Product entity) {
		return mapper.map(entity, ProductDTO.class);
	}//EntityToDto
	
	public List<ProductDTO> entityListToDtoList(List<Product> entities) {
		return entities.stream().map(this::entityToDto).collect(Collectors.toList());
	}//entityListToDtoList
	
	public Product dtoToEntity(ProductDTO dto) {
		return mapper.map(dto, Product.class);
	}//dtoToEntity
}
