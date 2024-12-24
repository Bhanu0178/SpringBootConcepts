package org.ease.Service.Impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.ease.DTO.AddProductDTO;
import org.ease.DTO.ProductDTO;
import org.ease.DTO.UpdateProductDTO;
import org.ease.Entity.Product;
import org.ease.Exception.ProductNotFoundException;
import org.ease.Mapper.ProductMapper;
import org.ease.Repository.IProductRepository;
import org.ease.Service.IProductService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepo;

	private ProductMapper productMapper;

	@Override
	public String addProduct(AddProductDTO dto) {
		log.info("addProduct() METHOD STARTED");
		Product product = Product.builder().name(dto.getName()).description(dto.getDescription())
				.price(Double.parseDouble(dto.getPrice())).quantity(Integer.parseInt(dto.getQuantity())).build();
		Product entity = productRepo.save(product);
		log.info("addProduct() METHOD ENDED");
		return "Product Added With Id: ".concat(String.valueOf(entity.getId()));
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		log.info("getAllProducts() METHOD STARTED");
		List<Product> entities = productRepo.findAll();
		if(entities.isEmpty()) {
			throw new ProductNotFoundException("Products Not Found!");
		}//if
		List<ProductDTO> dtos = productMapper.entityListToDtoList(entities)
																		.stream()
																		.sorted(Comparator.comparingLong(ProductDTO::getId))
																		.collect(Collectors.toList());
		log.info("getAllProducts() METHOD ENDED");
		return dtos;
	}//getAllProducts
	
	@Override
	public ProductDTO getProductById(Long id) {
		log.info("getProductById() METHOD STARTED");
		Product entity = productRepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product Not Found With Id: " + id));
		log.info("getProductById() METHOD ENDED");
		return productMapper.entityToDto(entity);
	}//getProductById
	
	@Override
	public String deleteProductById(Long id) {
		log.info("deleteProductById() METHOD STARTED");
		ProductDTO entity = this.getProductById(id);
		productRepo.delete(productMapper.dtoToEntity(entity));
		log.info("deleteProductById() METHOD ENDED");
		return "Product Deleted With Id: ".concat(String.valueOf(entity.getId()));
	}//deleteProductById
	
	@Override
	public String updateProductById(Long id, UpdateProductDTO product) {
		log.info("updateProductById() METHOD STARTED");
		ProductDTO dto = this.getProductById(id);
		dto.setDescription(product.getDescription());
		dto.setPrice(Double.parseDouble(product.getPrice()));
		dto.setQuantity(Integer.parseInt(product.getQuantity()));
		Product entity = productMapper.dtoToEntity(dto);
		productRepo.save(entity);
		log.info("updateProductById() METHOD ENDED");
		return "Product Updated Successfully With Id: ".concat(String.valueOf(id));
	}//updateProductById
}

