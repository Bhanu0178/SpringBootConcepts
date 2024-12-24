package org.ease.Error.Response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomExceptionErrorResponse {
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String trace;
	private String path;
}
