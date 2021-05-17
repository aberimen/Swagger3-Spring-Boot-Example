package com.aberimen.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) //dokümantasyon tipi
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.aberimen.swagger")) // ana paketimiz
				.paths(PathSelectors.ant("/api/v1/**"))  // hangi API adreslerini seçmesini belirtiyoruz
				.build().apiInfo(apiInfo());
	}
	
	
	private ApiInfo apiInfo() { // Dökümantasyon ile ilgili bilgilendirmeler
		
		return new ApiInfoBuilder()
				.description("Book API Dokümantasyonu")
				.contact(new Contact("Abdurrahman", "github.com/aberimen", "aberimen@aberimen"))
				.version("1.26")
				.build();
	}

}