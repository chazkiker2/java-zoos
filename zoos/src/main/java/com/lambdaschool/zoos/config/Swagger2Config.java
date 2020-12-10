package com.lambdaschool.zoos.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger2Config {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		                                              .apis(RequestHandlerSelectors.basePackage("com.lambdaschool.sampleemps"))
		                                              .paths(PathSelectors.regex("/.*"))
		                                              .build()
		                                              .apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Sample Employees Project")
		                           .description("A project used to introduce Swagger documentation")
		                           .contact(new Contact(
				                           "Chaz Kiker",
				                           "http://www.lambdaschool.com",
				                           "chaz@mail.com"
		                           ))
		                           .license("MIT")
		                           .licenseUrl("https://github.com/LambdaSchool/java-sampleemps/blob/master/LICENSE")
		                           .version("1.0.0")
		                           .build();
	}

}
