package org.ease.Exception.Handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.ease.Error.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;



@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * ex.getBindingResult();==> Return the BindingResult that this BindException wraps.
	 */
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Set<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex, HttpServletRequest req) {
		Map<String, String> map = new HashMap<>();
		Set<ErrorResponse> errorsSet = new HashSet<>();
		ex.getBindingResult().getFieldErrors().forEach(error-> map.put(error.getField(), error.getDefaultMessage()));
		ErrorResponse errorResponse = ErrorResponse.builder()
										.timestamp(LocalDateTime.now())
										.status(HttpStatus.BAD_REQUEST.value())
										.error(HttpStatus.BAD_REQUEST.getReasonPhrase())
										.errorFields(map)
										.trace(ex.getClass().getName())
										.path(req.getRequestURI())
										.build();
		errorsSet.add(errorResponse);
		return errorsSet;
	}//handleValidationErrors
	
	
}
