package com.advancejava.groupexercise1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private ApiInfo apiInfo() {
		return new ApiInfo("Bank Project", "Bench Bank Project",
				"1.0", "Terms if service", new Contact("Juan Dela Cruz", "", "juan@test.com"),
				"License of API", "API License URL", Collections.emptyList());
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	}

}