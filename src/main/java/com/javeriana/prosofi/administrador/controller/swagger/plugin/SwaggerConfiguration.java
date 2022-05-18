/*******************************************
 * PayU Latam - Copyright (c) 2013 - 2021  *
 * http://www.payulatam.com                *
 * 12/5/19 - 4:20 PM                       *
 ******************************************/
package com.javeriana.prosofi.administrador.controller.swagger.plugin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration to show the user the different EndPoints to use in Push Payments module
 *
 * @author Andres Martin Cantor Urrego (andres.cantor@payulatam.com)
 * @author Alejandro Cadena (alejandro.cadena@payulatam.com)
 * @version 1.0.0
 * @since 25/06/20
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

}
