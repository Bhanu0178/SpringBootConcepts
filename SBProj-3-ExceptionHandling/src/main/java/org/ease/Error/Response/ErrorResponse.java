package org.ease.Error.Response;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	Map<String, String> errorFields;
	private String trace;
	private String path;
}
