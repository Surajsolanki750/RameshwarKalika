package com.rkmb.RameshwarKalika.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final String serviceTitle = "Rameshwar Kalika Service";
	private final String serviceDescription = "This document contains APIS of client of Rameshwar Kalika";
	private final String version = "1.1.0";
	
	@Bean
	public Docket configApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.rkmb.RameshwarKalika.controller")).build()
				.apiInfo(apiEndPointInfo());
	}

	private ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder().title(serviceTitle).description(serviceDescription).version(version).build();
	}

}
