package com.travelbank.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.travelbank.cards.dto.CardsContactInfoDto;

@SpringBootApplication
@EnableDiscoveryClient
/*@ComponentScans({ @ComponentScan("com.travelbank.cards.controller") })
@EnableJpaRepositories("com.travelbank.cards.repository")
@EntityScan("com.travelbank.cards.model")*/
@EnableConfigurationProperties(value = {CardsContactInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "TravelBank Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Vinay Teja",
						email = "vinayteja@gmail.com",
						url = "https://www.travelbank.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.travelbank.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "TravelBank Cards microservice REST API Documentation",
				url = "https://www.travelbank.com/swagger-ui.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}
}
