package org.ease.Exception.Handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.ease.Error.Response.CustomExceptionErrorResponse;
import org.ease.Exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	//NO_CONTENT we have to use, but is not displaying the exception message, so that's why using NOT_FOUND
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(exception =  ProductNotFoundException.class)
	public Map<String, CustomExceptionErrorResponse> handleProductNotFoundException(ProductNotFoundException ex,
																														HttpServletRequest req) {
		Map<String, CustomExceptionErrorResponse> map = new HashMap<>();
		CustomExceptionErrorResponse customExceptionErrorResponse = CustomExceptionErrorResponse.builder()
																		.timestamp(LocalDateTime.now())
																		.status(HttpStatus.NOT_FOUND.value())
																		.error(HttpStatus.NOT_FOUND.getReasonPhrase())
																		.message(ex.getMessage())
																		.trace(ex.getClass().getName())
																		.path(req.getRequestURI())
																		.build();
		map.put("error_response", customExceptionErrorResponse);
		return map;
	}	
}
