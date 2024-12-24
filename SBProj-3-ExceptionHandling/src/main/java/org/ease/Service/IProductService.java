package org.ease.Service;

import java.util.List;

import org.ease.DTO.AddProductDTO;
import org.ease.DTO.ProductDTO;
import org.ease.DTO.UpdateProductDTO;

public interface IProductService {
	String addProduct(AddProductDTO dto);
	List<ProductDTO> getAllProducts();
	ProductDTO getProductById(Long id);
	String deleteProductById(Long id);
	String updateProductById(Long id, UpdateProductDTO updateProduct);
}
