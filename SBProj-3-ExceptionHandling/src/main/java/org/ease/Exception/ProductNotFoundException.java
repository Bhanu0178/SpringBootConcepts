package org.ease.Exception;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException() {
		super();
	}	
}
