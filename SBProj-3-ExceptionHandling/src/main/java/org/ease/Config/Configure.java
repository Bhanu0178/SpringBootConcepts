package org.ease.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {
	
	@Bean
	ModelMapper getInstance() {
		return new ModelMapper();
	}
}
