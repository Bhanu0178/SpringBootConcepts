package org.ease.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PRDT")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	
	@Id
	@SequenceGenerator(name = "prdt_gen", initialValue = 10050, allocationSize = 1)
	@GeneratedValue(generator = "prdt_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String description; 
	private Double price;
	private Integer quantity;
}
