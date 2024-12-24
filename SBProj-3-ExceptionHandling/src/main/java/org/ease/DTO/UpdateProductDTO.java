package org.ease.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateProductDTO {

	@NotBlank(message = "Description is Required")
	@Size(min = 3, max = 100, message = "Description Chars Should be Min 3 and Max 250")
	private String description;

	@NotBlank(message = "Price is Required")
	@Pattern(regexp = "^(50(\\.00)?|[5-9][0-9]{1,2}(\\.\\d{1,2})?|1000(\\.00)?)$", message = "Price should be between 50 and 1000")
	private String price;

	@NotBlank(message = "Quantity is Required")
	@Pattern(regexp = "^(100|[1-9]?[0-9])$", message = "Quantity should be between 1 and 100")
	private String quantity;
}
