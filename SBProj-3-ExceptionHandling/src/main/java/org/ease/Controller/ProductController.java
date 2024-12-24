package org.ease.Controller;

import java.util.List;

import org.ease.DTO.AddProductDTO;
import org.ease.DTO.ProductDTO;
import org.ease.DTO.UpdateProductDTO;
import org.ease.Service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/products")
public class ProductController {

	private IProductService productServe;

	@PostMapping(path = "/add")
	ResponseEntity<?> addProduct(@RequestBody(required = true) @Valid AddProductDTO request) {
		String product = productServe.addProduct(request);
		return new ResponseEntity<>(product, HttpStatus.CREATED); // 201, successful, Created
	}// addProduct

	@GetMapping(path = "/get")
	ResponseEntity<?> getAllProducts() {
		List<ProductDTO> allProducts = productServe.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK); // 200, successful, Ok
	}// getAllProducts
	
	@GetMapping(path = "/get/{id}")
	ResponseEntity<?> getProductById(@PathVariable Long id) {
		ProductDTO product = productServe.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK); // 200, successful, Ok
	}// getProductById
	
	@DeleteMapping(path = "/delete/{id}")
	ResponseEntity<?> deleteProductById(@PathVariable Long id) {
		String message = productServe.deleteProductById(id);
		return new ResponseEntity<>(message, HttpStatus.OK); // 200, successful, Ok
	}// deleteProductById
	
	@PutMapping(path = "/update/{id}")
	ResponseEntity<?> updateProductById(@PathVariable Long id,
																			@RequestBody @Valid UpdateProductDTO product) {
		String message = productServe.updateProductById(id, product);
		return new ResponseEntity<>(message, HttpStatus.CREATED); // 201, successful, Created
	}// updateProductById
	
}
